package com.example.eduard.shoppinglist.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.eduard.shoppinglist.Models.ShopingList;
import com.example.eduard.shoppinglist.Models.ShoppingItem;
import com.example.eduard.shoppinglist.R;

import java.util.ArrayList;

/**
 * Created by eduard on 3/29/2017.
 */

public class ShoppingListAdapter extends ArrayAdapter<ShopingList> {
    public Context mContext;
    public ArrayList<ShopingList> shopingLists;

    public ShoppingListAdapter(ArrayList<ShopingList> data, Context context) {
        super(context, R.layout.shopping_list_item, data);
        this.shopingLists = data;
        this.mContext = context;

    }

}
