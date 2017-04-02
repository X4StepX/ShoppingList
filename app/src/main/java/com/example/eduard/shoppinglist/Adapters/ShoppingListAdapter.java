package com.example.eduard.shoppinglist.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.eduard.shoppinglist.Models.ShoppingList;
import com.example.eduard.shoppinglist.R;

import java.util.ArrayList;

/**
 * Created by eduard on 3/29/2017.
 */

public class ShoppingListAdapter extends ArrayAdapter<ShoppingList>{
    private ArrayList<ShoppingList> shopingLists;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView mShoppingListName;
        TextView mShoppingListStoreName;
        TextView mShoppingListLocation;

    }

    public ShoppingListAdapter(ArrayList<ShoppingList> shopingList, Context context) {
        super(context, R.layout.shopping_list_item, shopingList);
        this.shopingLists = shopingList;
        this.mContext=context;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ShoppingList shopingList = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.shopping_list_item, parent, false);
            viewHolder.mShoppingListName = (TextView)convertView.findViewById(R.id.ShoppingListName);
            viewHolder.mShoppingListStoreName = (TextView)convertView.findViewById(R.id.shoppingListStoreName);
            viewHolder.mShoppingListLocation = (TextView)convertView.findViewById(R.id.shoppingListLocation);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.mShoppingListName.setText(shopingList.getListName());
        viewHolder.mShoppingListStoreName.setText(shopingList.getStoreName());
        viewHolder.mShoppingListLocation.setText(shopingList.getLocation());

        // Return the completed view to render on screen
        return convertView;
    }

}
