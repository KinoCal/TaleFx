package com.example.talefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("css/player.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Tale");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void init() {
        // Pre-loading or initializing application-level resources
        System.out.println("Initializing application...");
    }

    @Override
    public void stop() {
        // Cleanup tasks when the application is closing
        System.out.println("Application is closing...");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
