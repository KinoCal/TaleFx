package com.example.talefx.itemFactories;

import com.example.talefx.Items.abstractClasses.Item;

import java.util.HashMap;
import java.util.Map;

public class Factories {

    private final Map<String, ItemFactory> factoryMap = new HashMap<>();

    public Factories() {
        // Register factories
        factoryMap.put("weapon", new WeaponFactory());
        factoryMap.put("armor", new ArmorFactory());
        factoryMap.put("consumable", new ConsumableFactory());
        factoryMap.put("empty", new EmptyFactory());
    }

    public Item createItem(String itemType, String itemName, int quantity) {
        ItemFactory factory = factoryMap.get(itemType.toLowerCase());
        if (factory == null) {
            throw new IllegalArgumentException("Unknown item type: " + itemType);
        }
        return factory.createItem(itemName, quantity);
    }
}
