package com.example.talefx.itemFactories;


import com.example.talefx.Items.concreteClasses.consumables.ConsumableItem;

public class ConsumableFactory implements ItemFactory {

    @Override
    public ConsumableItem createItem(String itemName, int quantity) {
        return switch (itemName) {
            case "Hp Potion" ->
                    new ConsumableItem(8, "Hp Potion", "consumable", "common", 2, 3, quantity);
            case "Big Hp Potion" ->
                    new ConsumableItem(8, "Big Hp Potion", "consumable", "rare", 15, 10, quantity);
            case "Large Hp Potion" ->
                    new ConsumableItem(8, "Large Hp Potion", "consumable", "epic", 50, 35, quantity);
            default -> throw new IllegalArgumentException("Unknown item type: " + itemName);
        };
    }
}
