package controller;

import backend.I18N.I18N;
import backend.saveinstance.SaveInstance;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ResourceBundle;

public class StepOneController {


    private SaveInstance instance = SaveInstance.getInstance();

    @FXML
    private TextField bookNumberTextField;

    @FXML
    private AnchorPane pane;

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

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
    private ToggleButton sickWeek;

    @FXML
    private ToggleButton vacWeek;


    @FXML
    public void handleStepOneNextButtonAction(ActionEvent event) {
        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");
        try {
            if (bookNumberTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(I18N.get("key25"));
                alert.contentTextProperty().bind(I18N.createStringBinding("key31"));
                alert.showAndWait();
                return;
            }

            if (fromDate.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(I18N.get("key25"));
                alert.contentTextProperty().bind(I18N.createStringBinding("key32"));
                alert.showAndWait();
                return;
            } else {
                collectViewData();
                I18N.getLocale();
                pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/ProfessionalActivitiesView.fxml"), bundle));

            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void handleStepOneBackButtonAction(ActionEvent event) {
        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");
        try {
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/MainMenuView.fxml"), bundle));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ChooseFromDateToDate() {
        toDate.setValue(fromDate.getValue().plusDays(4));

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

    private void configureSickCheckBox(CheckBox checkBox) {
        if (checkBox.isSelected()) {
            sickSelectedCheckBoxes.add(checkBox);
        } else {
            sickUnselectedCheckBoxes.add(checkBox);
        }
        checkBox.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue) {
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
    public void handleSickCheckBoxAction() {
        configureSickCheckBox(SickMoCheckBox);
        configureSickCheckBox(SickTueCheckBox);
        configureSickCheckBox(SickWedCheckBox);
        configureSickCheckBox(SickThuCheckBox);
        configureSickCheckBox(SickFriCheckBox);

        sickNumCheckBoxesSelected.addListener(((observable, oldValue, newValue) -> {
            if (newValue.intValue() >= vacMaxSelected) {
                sickUnselectedCheckBoxes.forEach(checkBox -> checkBox.setDisable(true));
            } else {
                sickUnselectedCheckBoxes.forEach(checkBox -> checkBox.setDisable(false));
            }
        }));
    }

    @FXML
    public void handleToggleButtonAction() {
        ToggleGroup group = new ToggleGroup();
        vacWeek.setToggleGroup(group);
        sickWeek.setToggleGroup(group);

    }


    private void collectViewData() {
        int bookNumber = Integer.parseInt(bookNumberTextField.getText());
        String date = fromDate.getValue().toString();
        String secDate = toDate.getValue().toString();

        instance.setReportBookNumber(bookNumber);
        instance.setFromDate(date);
        instance.setToDate(secDate);
        System.out.println("Book number is: " + instance.getReportBookNumber());
        System.out.println(instance.getFromDate());
        System.out.println(instance.getToDate());
    }


}
