package controller;


import backend.CSVConfig.CSV;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class MainMenuController {

    @FXML
    private AnchorPane pane;

    @FXML
    private ChoiceBox languageChoiceBox;


    @FXML
    public void handleCreateReportButtonAction(ActionEvent event) {
        try {
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("StepOneView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleConfigButtonAction(ActionEvent event) {
        try {
            load("config");
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("ConfigurationView.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String load(String fileName) {
        String string;
        CSV csv = new CSV();
        csv.open(fileName, 'l');
        string = csv.load(fileName);
        csv.close();

        return string;
    }



}

