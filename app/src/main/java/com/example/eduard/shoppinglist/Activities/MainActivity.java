package com.example.eduard.shoppinglist.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eduard.shoppinglist.Adapters.ShoppingListAdapter;
import com.example.eduard.shoppinglist.DBHandler.DBHandler;
import com.example.eduard.shoppinglist.Models.ShoppingList;
import com.example.eduard.shoppinglist.R;

import java.sql.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.listview)
    ListView mListView;

    ShoppingListAdapter shoppingListAdapter;

    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        dbHandler = new DBHandler(getApplicationContext());
        ArrayList<ShoppingList> shoppingLists = dbHandler.getShoppingLists();
        shoppingListAdapter = new ShoppingListAdapter(shoppingLists, getApplicationContext());

        mListView.setAdapter(shoppingListAdapter);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addShoppingList();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void addShoppingList(){
        final View mView = LayoutInflater.from(this).inflate(R.layout.add_shopping_list, null);

        final EditText mShoppingListName = (EditText)mView.findViewById(R.id.ShoppingListName);
        final EditText mStoreName = (EditText)mView.findViewById(R.id.StoreName);
        final EditText mStoreLocation = (EditText)mView.findViewById(R.id.StoreLocation);

        Button mSaveButton = (Button)mView.findViewById(R.id.saveButton);
        Button mCancelButton = (Button)mView.findViewById(R.id.cancelButton);

        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    ShoppingList shoppingList = new ShoppingList(String.valueOf(mShoppingListName.getText()),String.valueOf(mStoreName.getText()), String.valueOf(mStoreLocation.getText()) );
                    dbHandler.insertShoppingList(shoppingList);
                    Toast.makeText(getApplicationContext(), String.valueOf(mShoppingListName.getText()) + " has been added", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }catch (Exception e){
                    Log.d("Error inserting List", e.toString());
                    Toast.makeText(getApplicationContext(), "Ann error occured", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
