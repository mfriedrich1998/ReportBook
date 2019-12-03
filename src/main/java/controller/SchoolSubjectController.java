package controller;

import backend.PDF.PDFGenerator;
import backend.saveinstance.SaveInstance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class SchoolSubjectController implements Initializable {

    private SaveInstance instance = SaveInstance.getInstance();

    @FXML
    private AnchorPane pane;

    @FXML
    private Button moreButton;

    @FXML
    private Button SecondMoreButton;

    @FXML
    private ChoiceBox subjectChoiceBox;

    @FXML
    private ChoiceBox subjectChoiceBox2;

    @FXML
    private ChoiceBox subjectChoiceBox3;

    @FXML
    private ChoiceBox subjectChoiceBox4;

    @FXML
    private ChoiceBox subjectChoiceBox5;

    @FXML
    private ChoiceBox subjectChoiceBox6;

    @FXML
    private ChoiceBox subjectChoiceBox7;

    @FXML
    private ChoiceBox secondSubjectChoiceBox;

    @FXML
    private ChoiceBox secondSubjectChoiceBox2;

    @FXML
    private ChoiceBox secondSubjectChoiceBox3;

    @FXML
    private ChoiceBox secondSubjectChoiceBox4;

    @FXML
    private ChoiceBox secondSubjectChoiceBox5;

    @FXML
    private ChoiceBox secondSubjectChoiceBox6;

    @FXML
    private ChoiceBox secondSubjectChoiceBox7;

    @FXML
    private TextField subjectTextField;

    @FXML
    private TextField subjectTextField2;

    @FXML
    private TextField subjectTextField3;

    @FXML
    private TextField subjectTextField4;

    @FXML
    private TextField subjectTextField5;

    @FXML
    private TextField subjectTextField6;

    @FXML
    private TextField subjectTextField7;

    @FXML
    private TextField secondSubjectTextField;

    @FXML
    private TextField secondSubjectTextField2;

    @FXML
    private TextField secondSubjectTextField3;

    @FXML
    private TextField secondSubjectTextField4;

    @FXML
    private TextField secondSubjectTextField5;

    @FXML
    private TextField secondSubjectTextField6;

    @FXML
    private TextField secondSubjectTextField7;

    @FXML
    private Label day1Label;

    @FXML
    private Label day2Label;

    @FXML
    private Button deleteButton;

    @FXML
    private Button secDeleteButton;

    private Map<ChoiceBox, TextField> left;

    private Map<ChoiceBox, TextField> right;


    @FXML
    public void handleSchoolSubjectsNextButtonAction(ActionEvent event) {
        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");
        collectViewData();
        System.out.println(instance.getInstructionsText());
        PDFGenerator pdfGenerator = new PDFGenerator();
        pdfGenerator.printPDF();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("PDF Gespeichert");
        alert.setContentText("I have a great message for you!");
        alert.showAndWait();
        try {
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/MainMenuView.fxml"), bundle));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleSchoolSubjectsBackButtonAction(ActionEvent event) {
        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");
        try {
            collectViewData();
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/InstructionsView.fxml"), bundle));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleMoreButtonAction() {
        int i = 2;
        for (Map.Entry<ChoiceBox, TextField> entry : left.entrySet()) {
            if (entry.getKey().getId().equals("" + i)) {
                ChoiceBox cb = entry.getKey();
                if (!cb.visibleProperty().getValue()) {
                    entry.getKey().visibleProperty().setValue(true);
                    entry.getValue().visibleProperty().setValue(true);
                    return;
                }
                i++;
            }
        }
    }

    @FXML
    public void handleDeleteButtonAction() {
        LinkedList<ChoiceBox> reversedLinkedListFromLinkedHashSetKey = new LinkedList<>(left.keySet());
        LinkedList<TextField> reversedLinkedListFromLinkedHashSetValue = new LinkedList<>(left.values());
        for (int i = reversedLinkedListFromLinkedHashSetKey.size() - 1; i >= 0; i--) {
            ChoiceBox cb = reversedLinkedListFromLinkedHashSetKey.get(i);
            TextField tf = reversedLinkedListFromLinkedHashSetValue.get(i);
            if (cb.visibleProperty().getValue()) {
                cb.visibleProperty().setValue(false);
                tf.visibleProperty().setValue(false);
                return;
            }
        }
    }

    private void configureSchoolSubjects() {
        left = new LinkedHashMap<>();
        subjectChoiceBox2.setId("2");
        subjectChoiceBox3.setId("3");
        subjectChoiceBox4.setId("4");
        subjectChoiceBox5.setId("5");
        subjectChoiceBox6.setId("6");
        subjectChoiceBox7.setId("7");
        left.put(subjectChoiceBox2, subjectTextField2);
        left.put(subjectChoiceBox3, subjectTextField3);
        left.put(subjectChoiceBox4, subjectTextField4);
        left.put(subjectChoiceBox5, subjectTextField5);
        left.put(subjectChoiceBox6, subjectTextField6);
        left.put(subjectChoiceBox7, subjectTextField7);
    }


    @FXML
    public void handleSecondMoreButtonAction(ActionEvent e) {
        int i = 2;
        for (Map.Entry<ChoiceBox, TextField> entry : right.entrySet()) {
            if (entry.getKey().getId().equals("" + i)) {
                ChoiceBox cb = entry.getKey();
                if (!cb.visibleProperty().getValue()) {
                    entry.getKey().visibleProperty().setValue(true);
                    entry.getValue().visibleProperty().setValue(true);
                    return;
                }
                i++;
            }
        }


    }

    @FXML
    public void handleSecondDeleteButtonAction() {
        LinkedList<ChoiceBox> reversedLinkedListFromLinkedHashSetKey = new LinkedList<>(right.keySet());
        LinkedList<TextField> reversedLinkedListFromLinkedHashSetValue = new LinkedList<>(right.values());
        for (int i = reversedLinkedListFromLinkedHashSetKey.size() - 1; i >= 0; i--) {
            ChoiceBox cb = reversedLinkedListFromLinkedHashSetKey.get(i);
            TextField tf = reversedLinkedListFromLinkedHashSetValue.get(i);
            if (cb.visibleProperty().getValue()) {
                cb.visibleProperty().setValue(false);
                tf.visibleProperty().setValue(false);
                return;
            }
        }
    }

    private void configureSecondSchoolSubjects() {
        right = new LinkedHashMap<>();
        secondSubjectChoiceBox2.setId("2");
        secondSubjectChoiceBox3.setId("3");
        secondSubjectChoiceBox4.setId("4");
        secondSubjectChoiceBox5.setId("5");
        secondSubjectChoiceBox6.setId("6");
        secondSubjectChoiceBox7.setId("7");
        right.put(secondSubjectChoiceBox2, secondSubjectTextField2);
        right.put(secondSubjectChoiceBox3, secondSubjectTextField3);
        right.put(secondSubjectChoiceBox4, secondSubjectTextField4);
        right.put(secondSubjectChoiceBox5, secondSubjectTextField5);
        right.put(secondSubjectChoiceBox6, secondSubjectTextField6);
        right.put(secondSubjectChoiceBox7, secondSubjectTextField7);

    }


    private void collectViewData() {

        String subject = subjectChoiceBox.getValue().toString();
        String input = subjectTextField.getText();

        String secondSubject = secondSubjectChoiceBox.getValue().toString();
        String secondInput = secondSubjectTextField.getText();

        collectSubjectData();


        instance.setSchoolSubject(subject);
        instance.setSubjectInput(input);
        instance.setSecondSchoolSubject(secondSubject);
        instance.setSecondSubjectInput(secondInput);
        collectSubjectData();
        collectSecondSubjectData();

    }

    private void collectSubjectData() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for (Map.Entry<ChoiceBox, TextField> entry : left.entrySet()) {
            map.put(entry.getKey().getValue().toString(), entry.getValue().getText());
            for (Map.Entry<String, String> entry1 : map.entrySet()) {
                System.out.println(entry1.getKey() + " " + entry1.getValue());
            }
        }
        instance.setLeftSubjects(map);
    }

    private void collectSecondSubjectData() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for (Map.Entry<ChoiceBox, TextField> entry : right.entrySet()) {
            map.put(entry.getKey().getValue().toString(), entry.getValue().getText());
            for (Map.Entry<String, String> entry1 : map.entrySet()) {
                System.out.println(entry1.getKey() + " " + entry1.getValue());
            }
        }
        instance.setRightSubjects(map);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (instance.getSubjectInput() != null) {
            subjectTextField.setText(instance.getSubjectInput());
        }
        if (instance.getSecondSubjectInput() != null) {
            secondSubjectTextField.setText(instance.getSecondSubjectInput());
        }
        if (instance.getSchoolSubject() != null) {
            subjectChoiceBox.setValue(instance.getSchoolSubject());
        }
        if (instance.getSecondSchoolSubject() != null) {
            secondSubjectChoiceBox.setValue(instance.getSecondSchoolSubject());
        }


        if (instance.getSelectedBoxes().isEmpty()) {
            SecondMoreButton.setDisable(true);
            secondSubjectTextField.setDisable(true);
            secondSubjectChoiceBox.setDisable(true);
            subjectTextField.setDisable(true);
            subjectChoiceBox.setDisable(true);
            moreButton.setDisable(true);
            deleteButton.setDisable(true);
            secDeleteButton.setDisable(true);
            day1Label.setText(" ");
            day2Label.setText(" ");

        }

        if (instance.getSelectedBoxes().size() == 1) {
            SecondMoreButton.setDisable(true);
            secondSubjectTextField.setDisable(true);
            secondSubjectChoiceBox.setDisable(true);
            secDeleteButton.setDisable(true);
            day2Label.setText(" ");
        }
        configureSchoolSubjects();
        configureSecondSchoolSubjects();
    }
}

