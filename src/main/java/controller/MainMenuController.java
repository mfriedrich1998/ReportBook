package controller;


import backend.CSVConfig.CSV;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private AnchorPane pane;

    @FXML
    private ChoiceBox languageChoiceBox;

    private Locale locale;

    private ResourceBundle bundle;

    @FXML
    private Button configButton;

    @FXML
    private Button createReportButton;


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

    @FXML
    public void handleEnglishChoice(ActionEvent event) {
        if(languageChoiceBox.getValue().equals("German")) {


            languageChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    loadLang("de");
                }
            });
        }

    }

    private void loadLang(String lang) {
        locale = new Locale(lang);
        bundle = ResourceBundle.getBundle("lang/lang", locale);
        configButton.setText(bundle.getString("key1"));
        createReportButton.setText(bundle.getString("key2"));

    }

    public void initialize(URL location, ResourceBundle resources) {

    }


}

