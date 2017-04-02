package com.example.eduard.shoppinglist.DBHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.eduard.shoppinglist.Models.ShoppingList;

import java.util.ArrayList;

/**
 * Created by eduard on 4/1/2017.
 */

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private Context _context;

    private static final String DATABASE_NAME = "shoppingList.db";
    //Table ShoppingList
    private static final String TABLE_SHOPPING_LIST = "ShoppingList";
    private static final String COL_SHOPPING_LIST_NAME = "Name";
    private static final String COL_SHOPPING_LIST_STORE_NAME = "StoreName";
    private static final String COL_SHOPPING_LIST_LOCATION = "StoreLocation";

    //Table ShoppingListItem
    private static final String TABLE_SHOPPING_ITEM = "ShoppingItem";
    private static final String COL_SHOPING_ITEM_NAME = "Name";
    private static final String COL_SHOPING_ITEM_AMOUNT = "Amount";
    private static final String COL_SHOPING_ITEM_CATEGORY = "Category";
    private static final String COL_SHOPING_ITEM_STOREAISLE = "StoreAisle";

    public SQLiteDatabase db = this.getWritableDatabase();

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        _context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SHOPPING_LIST_TABLE = "CREATE TABLE " + TABLE_SHOPPING_LIST + " ( " +
                COL_SHOPPING_LIST_NAME + " TEXT, " +
                COL_SHOPPING_LIST_STORE_NAME + " TEXT, " +
                COL_SHOPPING_LIST_LOCATION + " TEXT " +
                ")";

        String CREATE_SHOPPING_ITEM_TABLE = "CREATE TABLE " + TABLE_SHOPPING_ITEM + " ( " +
                COL_SHOPING_ITEM_NAME + " TEXT, " +
                COL_SHOPING_ITEM_AMOUNT + " TEXT, " +
                COL_SHOPING_ITEM_CATEGORY + " TEXT, " +
                COL_SHOPING_ITEM_STOREAISLE + " INTEGER " +
                ")";

        db.execSQL(CREATE_SHOPPING_LIST_TABLE);
        db.execSQL(CREATE_SHOPPING_ITEM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_SHOPPING_ITEM);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_SHOPPING_LIST);
        // Creating tables again
        onCreate(db);
    }

    public void insertShoppingList(ShoppingList shoppingList) {
        ContentValues values = new ContentValues();
        values.put(COL_SHOPPING_LIST_NAME, shoppingList.getListName());
        values.put(COL_SHOPPING_LIST_STORE_NAME, shoppingList.getStoreName());
        values.put(COL_SHOPPING_LIST_LOCATION, shoppingList.getLocation());

        db.insert(TABLE_SHOPPING_LIST, null, values);
    }

    public ArrayList<ShoppingList> getShoppingLists() {
        String selectQuery;
        selectQuery = "SELECT * FROM " + TABLE_SHOPPING_LIST;

        ArrayList<ShoppingList> shoppingLists = new ArrayList<ShoppingList>();
        //select all query
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ShoppingList shoppingList = new ShoppingList();
                shoppingList.setListName(cursor.getString(0));
                shoppingList.setStoreName(cursor.getString(1));
                shoppingList.setLocation(cursor.getString(2));
                shoppingLists.add(shoppingList);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return shoppingLists;
    }
}
