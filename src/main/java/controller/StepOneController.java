package controller;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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



    private void configureCheckBox(CheckBox checkBox){
        if(checkBox.isSelected()){
            selectedCheckBoxes.add(checkBox);
        }else {
            unselectedCheckBoxes.add(checkBox);
        }
        checkBox.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue){
                unselectedCheckBoxes.remove(checkBox);
                selectedCheckBoxes.add(checkBox);
            } else {
                selectedCheckBoxes.remove(checkBox);
                unselectedCheckBoxes.add(checkBox);
            }
        }));
    }

    @FXML
    public void handleCheckBoxAction(){
        configureCheckBox(SchoolMoCheckBox);
        configureCheckBox(SchoolTueCheckBox);
        configureCheckBox(SchoolWedCheckBox);
        configureCheckBox(SchoolThuCheckBox);
        configureCheckBox(SchoolFriCheckBox);

        numCheckBoxesSelected.addListener(((observable, oldValue, newValue) -> {
            if(newValue.intValue() >= maxSelected){
                unselectedCheckBoxes.forEach(checkBox -> checkBox.setDisable(true));
            } else {
                unselectedCheckBoxes.forEach(checkBox -> checkBox.setDisable(false));
            }
        }));
    }




}
