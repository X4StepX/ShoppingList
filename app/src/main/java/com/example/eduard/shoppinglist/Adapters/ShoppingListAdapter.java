package com.example.eduard.shoppinglist.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.eduard.shoppinglist.Models.ShopingList;
import com.example.eduard.shoppinglist.Models.ShoppingItem;
import com.example.eduard.shoppinglist.R;

import java.util.ArrayList;

/**
 * Created by eduard on 3/29/2017.
 */

public class ShoppingListAdapter extends ArrayAdapter<ShopingList>{
    private ArrayList<ShopingList> shopingLists;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

    }

    public ShoppingListAdapter(ArrayList<ShopingList> shopingList, Context context) {
        super(context, R.layout.shopping_list_item, shopingList);
        this.shopingLists = shopingList;
        this.mContext=context;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ShopingList shopingList = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.shopping_list_item, parent, false);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        // Return the completed view to render on screen
        return convertView;
    }

}
