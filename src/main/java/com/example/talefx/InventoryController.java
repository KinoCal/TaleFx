package com.example.talefx;

import com.example.talefx.Items.abstractClasses.Item;
import com.example.talefx.player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

public class InventoryController {

    @FXML
    private ListView<Item> inventoryListView;

    private Player player;

    public void initialize() {
        player = new Player(); // Or inject the player instance
        inventoryListView.setItems(player.getInventoryItems());

        // Set custom cell factory
        inventoryListView.setCellFactory(lv -> new CustomListCell());

        // Clear selection to prevent highlighting the first item
        inventoryListView.getSelectionModel().clearSelection();

        // Set mouse event handlers for each cell
        inventoryListView.setOnMouseClicked(this::onItemClicked);
    }

    private void onItemClicked(MouseEvent event) {
        if (event.getClickCount() == 2) { // Double-click
            Item selectedItem = inventoryListView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Handle double-click action on the item

                System.out.println("Double-clicked on: " + selectedItem);
            }
        }
    }

    private class CustomListCell extends ListCell<Item> {
        private Tooltip tooltip;

        @Override
        protected void updateItem(Item item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
                setTooltip(null);
                return;
            }
            // Set the text of each cell in the ListView
            setText(item.toString());

            // Set up a tooltip or other visual effect
            tooltip = new Tooltip("Name: " + item.getName() + "\nQuantity: " + item.getQuantity());
            setTooltip(tooltip);

            // Add mouse enter event to show the tooltip or handle hover logic
            setOnMouseEntered(event -> showTooltip(event));
            setOnMouseExited(event -> hideTooltip());
            setOnMouseClicked(event -> hideTooltip());
        }

        private void showTooltip(MouseEvent event) {
            if (tooltip != null) {
                tooltip.show(inventoryListView, event.getScreenX(), event.getScreenY()+50);
            }
        }

        private void hideTooltip() {
            if (tooltip != null) {
                tooltip.hide();
            }
        }
    }
}
