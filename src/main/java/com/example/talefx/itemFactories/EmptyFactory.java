package com.example.talefx.itemFactories;


import com.example.talefx.Items.abstractClasses.Item;
import com.example.talefx.Items.interfaces.Item_Empty;

public class EmptyFactory implements ItemFactory {

    @Override
    public Item createItem(String itemName, int quantity) {
        return switch (itemName) {
            case "empty" -> new Item_Empty();
            default -> throw new IllegalArgumentException("Unknown item type: " + itemName);
        };
    }
}
