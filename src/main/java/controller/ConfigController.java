package controller;

import backend.CSVConfig.CSV;
import backend.I18N.I18N;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Optional;
import java.util.ResourceBundle;


public class ConfigController {

    @FXML
    private AnchorPane pane;

    @FXML
    private Button configSaveButton;

    @FXML
    private Button configCancelButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField departmentTextField;

    @FXML
    public void handleConfigCancelButtonAction(ActionEvent event) {
        Window window = configCancelButton.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(window);
        alert.setHeaderText(I18N.get("key29"));
        alert.contentTextProperty().bind(I18N.createStringBinding("key30"));

        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");
        try {
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/MainMenuView.fxml"), bundle));
            } else if (result.get() == ButtonType.CANCEL) {
                alert.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleConfigSaveButtonAction(ActionEvent event) {
        Window window = configSaveButton.getScene().getWindow();
        if (nameTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(window);

            alert.setHeaderText(I18N.get("key25"));
            alert.contentTextProperty().bind(I18N.createStringBinding("key27"));
            alert.showAndWait();
            return;

        }
        if (departmentTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(window);
            alert.setHeaderText(I18N.get("key25"));
            alert.contentTextProperty().bind(I18N.createStringBinding("key26"));
            alert.showAndWait();
            return;
        }


        save("config");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(window);
        alert.setHeaderText(I18N.get("key28"));
        alert.showAndWait();

        ResourceBundle bundle = ResourceBundle.getBundle("lang/lang");
        try {
            pane.getChildren().setAll((AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("views/MainMenuView.fxml"), bundle));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void save(String fileName) {

        CSV csv = new CSV();
        csv.open(fileName, 's');
        csv.save(nameTextField.getText());
        csv.save(departmentTextField.getText());
        csv.close();
    }

}
