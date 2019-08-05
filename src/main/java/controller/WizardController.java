package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class WizardController {

    @FXML
    private AnchorPane pane;


    @FXML
    public void handleCreateReportButtonAction(ActionEvent event) {
        try{
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getResource("StepOneView.fxml")));
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}