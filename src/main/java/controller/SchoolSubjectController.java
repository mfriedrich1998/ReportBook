package controller;

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

    public int choiceBoxRow = 1;
    public int choiceBoxColumn = 0;
    public int textFieldRow = 1;
    public int textFieldColumn = 1;
    public int secChoiceBoxColumn = 3;
    public int secTextFieldColumn = 4;
    public int secChoiceBoxRow = 1;
    public int secTextFieldRow = 1;

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
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/InstructionsView.fxml")));
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
        gridPane.add(textField, textFieldColumn, textFieldRow);
        gridPane.add(choiceBox, choiceBoxColumn, choiceBoxRow);
        if (choiceBoxRow < 6) {
            choiceBoxRow++;
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
        gridPane.add(textField, secTextFieldColumn, secTextFieldRow);
        gridPane.add(choiceBox, secChoiceBoxColumn, secChoiceBoxRow);
        if (secChoiceBoxRow < 6) {
            secChoiceBoxRow++;
        }
        if(secTextFieldRow < 6){
            secTextFieldRow++;
        }
        else {
            SecondMoreButton.setDisable(true);
        }
    }
}
