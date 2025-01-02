package com.example.talefx.player;
//MAKE A GET INVENTORY FUNCTION THAT DISPLAYS THE PLAYERS INVO INFO TO THE UI UPDATE TEXT AREA
//


import com.example.talefx.Items.abstractClasses.Item;
import com.example.talefx.Items.concreteClasses.equipment.ArmorItem;
import com.example.talefx.Items.concreteClasses.equipment.WeaponItem;
import com.example.talefx.Items.interfaces.Item_Empty;
import com.example.talefx.itemFactories.Factories;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private Factories factories = new Factories();
    private String username;
    private String password;
    private WeaponItem currentWeapon;
    private ArmorItem currentArmor;
    private int damageDealt;
    private int maxHp;
    private int currentHp;
    private DoubleProperty maxExp;
    private DoubleProperty currentExp;
    private int strengthStat;
    private int defenceStat;
    private IntegerProperty level;
    private int gold;
    private int statPoints;
    private double attackSpeed;
    private int damage;
    private int armor;
    private int inventorySize;
    public Item empty = new Item_Empty();
    public Item emptyWeapon = new WeaponItem(0, "empty", "weapon", "empty", 0, 0, 1);
    public Item emptyArmour = new ArmorItem(1, "empty", "armor", "empty", 0, 0, 1);


    public Item[] equippedItems = new Item[2];
    // Inventory as an ObservableList
    private ObservableList<Item> inventoryItems = FXCollections.observableArrayList();


    public Player() {

        equippedItems[0] = emptyWeapon;
        equippedItems[1] = emptyArmour;

        inventoryItems.add(factories.createItem("weapon", "Dagger", 1));
        inventoryItems.add(factories.createItem("weapon", "Sword", 1));
        inventoryItems.add(factories.createItem("weapon", "Mace", 1));
        inventoryItems.add(factories.createItem("weapon", "Long Sword", 1));
        inventoryItems.add(factories.createItem("consumable", "Hp Potion", 1));
        inventoryItems.add(empty);


        currentWeapon = (WeaponItem) equippedItems[0];
        currentArmor = (ArmorItem) equippedItems[1];

        statPoints = 0;
        level = new SimpleIntegerProperty(1);
        maxHp = 10;
        currentHp = maxHp;
        attackSpeed = 2.0;
        strengthStat = 1;
        defenceStat = 1;
        damageDealt = 0;
        damage = 0;
        armor = 0;
        currentExp = new SimpleDoubleProperty(0);
        maxExp = new SimpleDoubleProperty(level.get() * 10);
        gold = 100;
        inventorySize = 30;

    }

    public void gainXp(double amount) {
        setCurrentExp(getCurrentExp() + amount);
        if (getCurrentExp() >= getMaxExp()) {
            //levelUp();
        }
    }

    private void levelUp() {
        setCurrentLevel(getCurrentLevel()+1);
        setCurrentExp(0);
        setMaxExp(getCurrentLevel()*10);

    }

    // Getter and setter for maxExp
    public double getMaxExp() {
        return maxExp.get();
    }

    public void setMaxExp(double maxExp) {
        this.maxExp.set(maxExp);
    }

    public DoubleProperty maxExpProperty() {
        return maxExp;
    }

    // Getter and setter for currentExp
    public double getCurrentExp() {
        return currentExp.get();
    }

    public void setCurrentExp(double currentExp) {
        this.currentExp.set(currentExp);
    }

    public DoubleProperty currentExpProperty() {
        return currentExp;
    }

    public int getCurrentLevel(){
        return level.get();
    }

    public void setCurrentLevel(int level){
        this.level.set(level);
    }

    public IntegerProperty levelProperty(){
        return level;
    }

    public Item getEquippedItem(int index) {
        return equippedItems[index];
    }

    public void setEquippedItems(Item item, int index) {
        equippedItems[index] = item;
    }

    // Inventory management methods
    public ObservableList<Item> getInventoryItems() {
        return inventoryItems;
    }

    public void addItemToInventory(Item item) {
        inventoryItems.add(item);
    }

    public boolean removeItemFromInventory(Item item) {
        return inventoryItems.remove(item);
    }

    public Item getItemAtIndex(int index) {
        return inventoryItems.get(index);
    }

    public int getInventorySize() {
        return inventoryItems.size();
    }

    public boolean isInventoryFull() {
        Boolean check = false;
        for (Item item : inventoryItems) {
            if (!item.getName().equals("empty")) {
                check = true;
            } else {
                check = false;
            }
        }
        return check;
    }

    public boolean IsPlayerHpZero() {
        boolean isZero = false;
        if (getCurrentHp() == 0) {
            System.out.println("player is dead");
            setCurrentHp(0);
            isZero = true;
        }
        return isZero;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }


    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void decreaseGold(int gold) {
        this.gold -= gold;
    }

    public void increaseGold(int gold) {
        this.gold += gold;
    }

    public void takeDamage(int damage) {
        setCurrentHp(Math.max(0, getCurrentHp() - damage));
        if (getCurrentHp() == 0) {

        }
    }

    public void healPlayer(int amount) {
        setCurrentHp(Math.min(getMaxHp(), getCurrentHp() + amount));
        if (currentHp > maxHp) {
            setCurrentHp(maxHp);
        }
    }

    public WeaponItem getCurrentWeapon() {
        return currentWeapon;
    }


    public void setCurrentWeapon(WeaponItem currentWeapon) {
        this.currentWeapon = currentWeapon;
    }


    public ArmorItem getCurrentArmor() {
        return currentArmor;
    }


    public void setCurrentArmor(ArmorItem currentArmor) {
        this.currentArmor = (ArmorItem) currentArmor;
    }


    public int getDamage() {
        return damage;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }


    public int getArmor() {
        return armor;
    }


    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getStrengthStat() {
        return strengthStat;
    }


    public void setStrengthStat(int strengthStat) {
        this.strengthStat = strengthStat;
    }

    public void increaseStrengthStat(int amount) {
        this.strengthStat += amount;
    }


    public int getDefenceStat() {
        return defenceStat;
    }


    public void setDefenceStat(int defenceStat) {
        this.defenceStat = defenceStat;
    }

    public void increaseDefenceStat(int amount) {
        this.defenceStat += amount;
    }

    @Override
    public String toString() {
        return "Player{" +
                username + "//" +
                "currentWeapon=" + currentWeapon.getName() +
                ", currentArmor=" + currentArmor.getName() +
                ", maxHp=" + maxHp +
                ", currentHp=" + currentHp +
                ", maxExp=" + maxExp +
                ", currentExp=" + currentExp +
                ", strengthStat=" + strengthStat +
                ", defenceStat=" + defenceStat +
                ", level=" + level +
                ", gold=" + gold +
                ", damage=" + getDamage() +
                ", armor=" + armor +
                '}';
    }


    public boolean isInventoryIndexEmpty(int index) {
        Boolean isEmpty;
        if (inventoryItems.get(index).getName().isEmpty()) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        return isEmpty;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(int damage) {
        this.damageDealt = damage;
    }

    public List<Item> getConsumableItemList() {
        List<Item> consumableList = new ArrayList<>();
        for (Item item : inventoryItems) {
            if (item.getType().equals("consumable")) {
                consumableList.add(item);
            }
        }
        return consumableList;
    }

    public int getStatPoints() {
        return statPoints;
    }

    public void setStatPoints(int amount) {
        statPoints = amount;
    }

    public void increaseStatPoints(int amount) {
        this.statPoints += amount;
    }


}

