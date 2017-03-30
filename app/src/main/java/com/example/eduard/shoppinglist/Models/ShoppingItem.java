package com.example.eduard.shoppinglist.Models;

/**
 * Created by eduard on 3/29/2017.
 */

public class ShoppingItem {
    public String ShoppingItemName;
    public String Amount;
    public String Category;
    public String StoreAisle;

    public ShoppingItem() {
    }

    public ShoppingItem(String shoppingItemName, String amount, String category, String storeAisle) {
        ShoppingItemName = shoppingItemName;
        Amount = amount;
        Category = category;
        StoreAisle = storeAisle;
    }

    public String getShoppingItemName() {
        return ShoppingItemName;
    }

    public void setShoppingItemName(String shoppingItemName) {
        ShoppingItemName = shoppingItemName;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getStoreAisle() {
        return StoreAisle;
    }

    public void setStoreAisle(String storeAisle) {
        StoreAisle = storeAisle;
    }
}
