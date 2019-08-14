package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class InstructionsController {

    @FXML
    private AnchorPane pane;



    @FXML
    public void handleInstructionsNextButtonAction(ActionEvent event){
        try {

            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("SchoolSubjectsTwoView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @FXML
    public void handleInstructionsBackButtonAction(ActionEvent event){
        try {
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("ProfessionalActivitiesView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


