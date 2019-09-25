package controller;

import backend.saveinstance.SaveInstance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class ActivitiesController {

    private SaveInstance instance = SaveInstance.getInstance();

    @FXML
    private AnchorPane pane;

    @FXML
    public TextArea ProfessionalActivitiesTextArea;


    @FXML
    public void handleActivitiesNextButtonAction(ActionEvent event) {
        System.out.println("This is the number:" + instance.getReportBookNumber());
        System.out.println(instance.getFromDate());
        collectViewData();

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


    private void collectViewData(){
        String text = ProfessionalActivitiesTextArea.getText();

        instance.setActivitiesText(text);
        System.out.println(instance.getActivitiesText());

    }
}
