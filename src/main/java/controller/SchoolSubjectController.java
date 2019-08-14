package controller;

import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import views.PDFPreview;

import java.io.IOException;

public class SchoolSubjectController {


    @FXML
    private AnchorPane pane;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button moreButton;

    @FXML
    private ChoiceBox subjectChoiceBox;

    public int choiceboxRow = 1;
    public int choiceBoxColumn = 0;
    public int textFieldRow = 1;
    public int textfieldColumn = 1;
    public int SecChoiceBoxColumn = 3;
    public int SecTextFieldColumn = 4;
    public int SecChoiceboxRow = 1;
    public int SecTextFieldRow = 1;

    @FXML
    private ChoiceBox secondSubjectChoiceBox;

    @FXML
    private Button SecondMoreButton;


    @FXML
    public void handleSchoolSubjectsNextButtonAction(ActionEvent event) {
        PDFPreview pdfPreview = new PDFPreview();
        System.out.println(pdfPreview);

    }

    @FXML
    public void handleSchoolSubjectsBackButtonAction(ActionEvent event) {
        try {
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("InstructionsView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleMoreButtonAction(ActionEvent event) {

        TextField textField = new TextField();
        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.setValue("ITS");
        choiceBox.setItems(subjectChoiceBox.getItems());
        gridPane.add(textField, textfieldColumn, textFieldRow);
        gridPane.add(choiceBox, choiceBoxColumn, choiceboxRow);
        if (choiceboxRow < 6) {
            choiceboxRow++;
        }
        if (textFieldRow < 6) {
            textFieldRow++;
        } else {
            moreButton.setDisable(true);
        }

    }

    @FXML
    public void handleSecondMoreButtonAction(ActionEvent e) {
        TextField textField = new TextField();
        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.setValue("ITS");
        choiceBox.setItems(secondSubjectChoiceBox.getItems());
        gridPane.add(textField, SecTextFieldColumn, SecTextFieldRow);
        gridPane.add(choiceBox, SecChoiceBoxColumn, SecChoiceboxRow);
        if (SecChoiceboxRow < 6) {
            SecChoiceboxRow++;
        }
        if(SecTextFieldRow < 6){
            SecTextFieldRow++;
        }
        else {
            SecondMoreButton.setDisable(true);
        }
    }
}
