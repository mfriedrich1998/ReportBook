package controller;

import backend.I18N.I18N;
import backend.saveinstance.SaveInstance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActivitiesController implements Initializable {

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

        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");

        try {
            if (ProfessionalActivitiesTextArea.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(I18N.get("key25"));
                alert.contentTextProperty().bind(I18N.createStringBinding("key33"));
                alert.showAndWait();
                return;
            } else {
                pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/InstructionsView.fxml"), bundle));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleActivitiesBackButtonAction(ActionEvent event) {
        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");
        try {
            collectViewData();
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/StepOneView.fxml"), bundle));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void collectViewData() {
        String text = ProfessionalActivitiesTextArea.getText();
        instance.setActivitiesText(text);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       if (instance.getActivitiesText() != null) {
            ProfessionalActivitiesTextArea.setText(instance.getActivitiesText());
        }

    }
}
