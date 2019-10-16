package controller;


import backend.CSVConfig.CSV;
import backend.I18N.I18N;
import backend.saveinstance.SaveInstance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainMenuController {

    private SaveInstance instance = SaveInstance.getInstance();

    @FXML
    private AnchorPane pane;

    @FXML
    private Button configButton;

    @FXML
    private Button createReportButton;

    @FXML
    private Button DeButton;

    @FXML
    private Button EnButton;


    @FXML
    public void handleCreateReportButtonAction(ActionEvent event) {
        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");
        try {
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/StepOneView.fxml"), bundle));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleConfigButtonAction(ActionEvent event) {
        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");
        try {
            load("config");
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/ConfigurationView.fxml"), bundle));

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


    @FXML
    public void handleGermanButtonAction() {
        switchLanguage(Locale.GERMAN);
        createReportButton.textProperty().bind(I18N.createStringBinding("key2"));
        configButton.textProperty().bind(I18N.createStringBinding("key1"));


    }

    @FXML
    public void handleEnglishButtonAction() {
        switchLanguage(Locale.ENGLISH);
        createReportButton.textProperty().bind(I18N.createStringBinding("key2"));
        configButton.textProperty().bind(I18N.createStringBinding("key1"));
    }

    private void switchLanguage(Locale locale) {
        I18N.setLocale(locale);
    }


}

