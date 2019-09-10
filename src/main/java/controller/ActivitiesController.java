package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class ActivitiesController  {

    @FXML
    private AnchorPane pane;

    @FXML
    public TextArea ProfessionalActivitiesTextArea;




    @FXML
    public void handleActivitiesNextButtonAction(ActionEvent event){
        try {
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/InstructionsView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleActivitiesBackButtonAction(ActionEvent event) {
        try {
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/StepOneView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();

        }

    }


}
