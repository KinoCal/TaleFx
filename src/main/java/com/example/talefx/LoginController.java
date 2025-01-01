package com.example.talefx;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;


    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (isValidLogin(username, password)) {
            // Load the main view
            try {
                Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("player.css").toExternalForm());

                // Get the current stage and set the new scene
                Stage primaryStage = (Stage) usernameField.getScene().getWindow();
                primaryStage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Show error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("Please enter the correct username and password.");
            alert.showAndWait();
        }
    }

    private boolean isValidLogin(String username, String password) {
        // For demonstration purposes, just check a hardcoded username/password
        return "user".equals(username) && "password".equals(password);
    }
}
