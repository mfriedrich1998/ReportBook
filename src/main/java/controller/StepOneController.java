package controller;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import views.PDFPreview;

import java.io.IOException;

public class StepOneController {

    @FXML
    private AnchorPane pane;

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

    @FXML
    private RadioButton sickDaysWeek;

    @FXML
    private RadioButton vacDaysWeek;

    private ObservableSet<RadioButton> selected = FXCollections.observableSet();

    private ObservableSet<RadioButton> unselected = FXCollections.observableSet();

    @FXML
    private CheckBox SchoolMoCheckBox;

    @FXML
    private CheckBox SchoolTueCheckBox;

    @FXML
    private CheckBox SchoolWedCheckBox;

    @FXML
    private CheckBox SchoolThuCheckBox;

    @FXML
    private CheckBox SchoolFriCheckBox;

    private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();

    private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();

    private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);

    private final int maxSelected = 2;

    @FXML
    private CheckBox VacMoCheckBox;

    @FXML
    private CheckBox VacTueCheckBox;

    @FXML
    private CheckBox VacWedCheckBox;

    @FXML
    private CheckBox VacThuCheckBox;

    @FXML
    private CheckBox VacFriCheckBox;

    private ObservableSet<CheckBox> vacSelectedCheckBoxes = FXCollections.observableSet();

    private ObservableSet<CheckBox> vacUnselectedCheckBoxes = FXCollections.observableSet();

    private IntegerBinding vacNumCheckBoxesSelected = Bindings.size(vacSelectedCheckBoxes);

    private final int vacMaxSelected = 4;

    @FXML
    private CheckBox SickMoCheckBox;

    @FXML
    private CheckBox SickTueCheckBox;

    @FXML
    private CheckBox SickWedCheckBox;

    @FXML
    private CheckBox SickThuCheckBox;

    @FXML
    private CheckBox SickFriCheckBox;

    private ObservableSet<CheckBox> sickSelectedCheckBoxes = FXCollections.observableSet();

    private ObservableSet<CheckBox> sickUnselectedCheckBoxes = FXCollections.observableSet();

    private IntegerBinding sickNumCheckBoxesSelected = Bindings.size(sickSelectedCheckBoxes);



    @FXML
    public void handleStepOneNextButtonAction(ActionEvent event) {

        try {
            if (sickDaysWeek.isSelected() || vacDaysWeek.isSelected()) {
                PDFPreview pdfPreview = new PDFPreview();
                System.out.println(pdfPreview);

            } else {
                pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("ProfessionalActivitiesView.fxml")));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void handleStepOneBackButtonAction(ActionEvent event) {
        try {
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("MainMenuView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ChooseFromDateToDate() {
        toDate.setValue(fromDate.getValue().plusDays(4));

    }



    @FXML
    public void handleRadioButtonAction() {
        ToggleGroup toggleGroup = new ToggleGroup();
        sickDaysWeek.setToggleGroup(toggleGroup);
        vacDaysWeek.setToggleGroup(toggleGroup);
    }


    private void configureCheckBox(CheckBox checkBox) {
        if (checkBox.isSelected()) {
            selectedCheckBoxes.add(checkBox);
        } else {
            unselectedCheckBoxes.add(checkBox);
        }
        checkBox.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue) {
                unselectedCheckBoxes.remove(checkBox);
                selectedCheckBoxes.add(checkBox);
            } else {
                selectedCheckBoxes.remove(checkBox);
                unselectedCheckBoxes.add(checkBox);
            }
        }));
    }

    private void configureVacCheckBox(CheckBox checkBox) {
        if (checkBox.isSelected()) {
            vacSelectedCheckBoxes.add(checkBox);
        } else {
            vacUnselectedCheckBoxes.add(checkBox);
        }
        checkBox.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue) {
                vacUnselectedCheckBoxes.remove(checkBox);
                vacSelectedCheckBoxes.add(checkBox);
            } else {
                vacSelectedCheckBoxes.remove(checkBox);
                vacUnselectedCheckBoxes.add(checkBox);
            }

        }));
    }

    private void configureSickCheckBox(CheckBox checkBox){
        if(checkBox.isSelected()){
            sickSelectedCheckBoxes.add(checkBox);
        } else {
            sickUnselectedCheckBoxes.add(checkBox);
        }
        checkBox.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue) {
                sickUnselectedCheckBoxes.remove(checkBox);
                sickSelectedCheckBoxes.add(checkBox);
            } else {
                sickSelectedCheckBoxes.remove(checkBox);
                sickUnselectedCheckBoxes.add(checkBox);
            }
        }));
    }

    @FXML
    public void handleCheckBoxAction() {
        configureCheckBox(SchoolMoCheckBox);
        configureCheckBox(SchoolTueCheckBox);
        configureCheckBox(SchoolWedCheckBox);
        configureCheckBox(SchoolThuCheckBox);
        configureCheckBox(SchoolFriCheckBox);

        numCheckBoxesSelected.addListener(((observable, oldValue, newValue) -> {
            if (newValue.intValue() >= maxSelected) {
                unselectedCheckBoxes.forEach(checkBox -> checkBox.setDisable(true));
            } else {
                unselectedCheckBoxes.forEach(checkBox -> checkBox.setDisable(false));
            }
        }));

    }

    @FXML
    public void handleVacCheckBoxAction() {
        configureVacCheckBox(VacMoCheckBox);
        configureVacCheckBox(VacTueCheckBox);
        configureVacCheckBox(VacWedCheckBox);
        configureVacCheckBox(VacThuCheckBox);
        configureVacCheckBox(VacFriCheckBox);

        vacNumCheckBoxesSelected.addListener(((observable, oldValue, newValue) -> {
            if (newValue.intValue() >= vacMaxSelected) {
                vacUnselectedCheckBoxes.forEach(checkBox -> checkBox.setDisable(true));
            } else {
                vacUnselectedCheckBoxes.forEach(checkBox -> checkBox.setDisable(false));
            }
        }));
    }

    @FXML
    public void handleSickCheckBoxAction(){
        configureSickCheckBox(SickMoCheckBox);
        configureSickCheckBox(SickTueCheckBox);
        configureSickCheckBox(SickWedCheckBox);
        configureSickCheckBox(SickThuCheckBox);
        configureSickCheckBox(SickFriCheckBox);

        sickNumCheckBoxesSelected.addListener(((observable, oldValue, newValue) -> {
            if(newValue.intValue() >= vacMaxSelected){
                sickUnselectedCheckBoxes.forEach(checkBox -> checkBox.setDisable(true));
            } else {
                sickUnselectedCheckBoxes.forEach(checkBox -> checkBox.setDisable(false));
            }
        }));
    }

}
