package com.example.eduard.shoppinglist.Models;

/**
 * Created by eduard on 3/29/2017.
 */

public class ShoppingList {
    public String ListName;
    public String StoreName;
    public String Location;

    public ShoppingList() {
    }

    public ShoppingList(String listName, String storeName, String location) {
        ListName = listName;
        StoreName = storeName;
        Location = location;
    }

    public String getListName() {
        return ListName;
    }

    public void setListName(String listName) {
        ListName = listName;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
