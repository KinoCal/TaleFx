package com.example.talefx.itemFactories;


import com.example.talefx.Items.concreteClasses.equipment.WeaponItem;

public class WeaponFactory implements ItemFactory {

    @Override
    public WeaponItem createItem(String itemName, int quantity) {
        return switch (itemName) {
            case "empty" -> new WeaponItem(0, "empty", "weapon", "empty", 0, 0, quantity);
            //Common
            case "Dagger" -> new WeaponItem(0, "Dagger", "weapon", "common", 2, 1, quantity);
            case "Short Sword" ->
                    new WeaponItem(0, "Short Sword", "weapon", "common", 3, 2, quantity);
            //Rare
            case "Sword" -> new WeaponItem(0, "Sword", "weapon", "rare", 5, 6, quantity);
            case "Long Sword" -> new WeaponItem(0, "Long Sword", "weapon", "rare", 7, 4, quantity);
            //Epic
            case "Mace" -> new WeaponItem(0, "Mace", "weapon", "epic", 10, 6, quantity);
            //Legendary
            case "God Sword" ->
                    new WeaponItem(0, "God Sword", "weapon", "legendary", 22, 20, quantity);
            default -> throw new IllegalArgumentException("Unknown item type: " + itemName);
        };
    }
}
