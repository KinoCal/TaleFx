package com.example.talefx.Items.concreteClasses.consumables;


import com.example.talefx.Items.abstractClasses.Item;
import com.example.talefx.Items.interfaces.Consumable;

public class ConsumableItem extends Item implements Consumable {
    private int healingValue;

    public ConsumableItem(int itemIndex, String name, String type, String rarity, int price, int healingValue, int quantity) {
        super(itemIndex, name, type, rarity, price, quantity);
        this.healingValue = healingValue;
    }

    @Override
    public int getHealingValue() {
        return healingValue;
    }

    @Override
    public int setHealingValue(int healingValue) {
        return 0;
    }


}
