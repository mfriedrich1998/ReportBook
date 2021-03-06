package controller;


import backend.I18N.I18N;
import backend.saveinstance.SaveInstance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class InstructionsController implements Initializable {

    private SaveInstance instance = SaveInstance.getInstance();

    @FXML
    private TextArea InstructionsTextArea;

    @FXML
    private AnchorPane pane;


    @FXML
    public void handleInstructionsNextButtonAction(ActionEvent event) {
        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");
        try {
            I18N.getLocale();
            System.out.println(instance.getActivitiesText());
            collectViewData();
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/SchoolSubjectsTwoView.fxml"), bundle));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void handleInstructionsBackButtonAction(ActionEvent event) {
        InstructionsTextArea.setText(instance.getInstructionsText());
        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");
        try {
            collectViewData();
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/ProfessionalActivitiesView.fxml"), bundle));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void collectViewData() {
        String text = InstructionsTextArea.getText();

        instance.setInstructionsText(text);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (instance.getInstructionsText() != null) {
            InstructionsTextArea.setText(instance.getInstructionsText());
        }
    }
}


