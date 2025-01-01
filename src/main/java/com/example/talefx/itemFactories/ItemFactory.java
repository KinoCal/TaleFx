package com.example.talefx.itemFactories;


import com.example.talefx.Items.abstractClasses.Item;

public interface ItemFactory {
    Item createItem(String itemName, int quantity);
}
