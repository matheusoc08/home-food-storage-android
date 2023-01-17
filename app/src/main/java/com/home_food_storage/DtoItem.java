package com.home_food_storage;

public class DtoItem {

    private String itemName, itemDescription;
    private double itemWeight, itemPrice;
    private int itemQuantity;
    private boolean itemBought;

    public DtoItem() { }

    public DtoItem(String itemName, String itemDescription, double itemWeight, double itemPrice, int itemQuantity, boolean itemBought) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemBought = itemBought;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public boolean isItemBought() {
        return itemBought;
    }

    public void setItemBought(boolean itemBought) {
        this.itemBought = itemBought;
    }
}
