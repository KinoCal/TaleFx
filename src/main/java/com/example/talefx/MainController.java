package com.example.talefx;

import com.example.talefx.player.Player;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainController {
    @FXML
    private Pane dynamicContent;

    @FXML
    private Pane progressBarContainer;

    @FXML
    private ProgressBar playerExpProgressBar;

    @FXML
    private Label playerExpProgressLabel;

    private Player player;
    private Label expTooltipLabel;


    public void showInventoryView() {
        loadView("InventoryView.fxml");
        player.setCurrentExp(player.getCurrentExp()+1.2);
    }

    private void loadView(String fxmlFile) {
        try {
            Pane view = FXMLLoader.load(getClass().getResource(fxmlFile));
            dynamicContent.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void initialize() {
        player = new Player();
        // Bind ProgressBar progress to currentExp / maxExp
        playerExpProgressBar.progressProperty().bind(player.currentExpProperty().divide(player.maxExpProperty()));
        // Optionally handle updates when maxExp changes
        player.maxExpProperty().addListener((observable, oldValue, newValue) -> {

        });
        // Update the progress text dynamically
        playerExpProgressLabel.textProperty().bind(
                Bindings.createStringBinding(
                        () -> String.format("%.3f%%", player.currentExpProperty().get()), player.currentExpProperty()
                )
        );

        // Initialize the tooltip label
        expTooltipLabel = new Label();
        expTooltipLabel.setStyle("-fx-background-color: black; -fx-text-fill: white; ");

        // Add mouse event handlers
        playerExpProgressBar.setOnMouseEntered(event -> {
            double x = playerExpProgressBar.getLayoutX();
            double y = playerExpProgressBar.getLayoutY() - 30; // Adjust position slightly above
            expTooltipLabel.setText("Current EXP: " + player.getCurrentExp() + " / " + player.getMaxExp());
            expTooltipLabel.setLayoutX(x);
            expTooltipLabel.setLayoutY(y);
            progressBarContainer.getChildren().add(expTooltipLabel); // Show the tooltip
        });

        playerExpProgressBar.setOnMouseExited(event -> {
            progressBarContainer.getChildren().remove(expTooltipLabel); // Hide the tooltip
        });


    }


}
