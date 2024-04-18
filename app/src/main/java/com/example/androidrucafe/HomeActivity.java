package com.example.androidrucafe;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Cart cart = Cart.getInstance();
    private ArrayAdapter<MenuItem> adapter;
    private ListView listview;

    /**
     * Perform initial setup
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Cart.cartList);
        listview = findViewById(R.id.homeListView);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
    }

    /**
     * The event Handler for the onItemClick event on the ListView
     * @param adapterView The AdapterView where the click happened.
     * @param view The View within the AdapterView that was clicked (in this example is ListView)
     * @param i the index/position of the view that was clicked in the adapter.
     * @param l the row id (index) of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Cart.cartList.remove(i);
        //list.remove((int) l); //type cast a long to an int if you use the row id
        adapter.notifyDataSetChanged(); //notify the attached observer the underlying data has been changed.
        //for (String s: list)  //a test to print out the data source to see if they are in sync
        //    System.out.println(s);
    }

    /**
     * Perform on resuming view
     */
    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void goToSandwichView(View view) {
        Intent intent = new Intent(this, SandwichActivity.class);
        startActivity(intent);
    }

    public void goToDonutView(View view) {
        Intent intent = new Intent(this, DonutActivity.class);
        startActivity(intent);
    }

    public void goToCoffeeView(View view) {
        Intent intent = new Intent(this, CoffeeActivity.class);
        startActivity(intent);
    }

    public void goToOrdersView(View view) {
        Intent intent = new Intent(this, OrdersActivity.class);
        startActivity(intent);
    }

    /**
     * Display an alert to the user
     */
    private void showAlert(String message) {
        androidx.appcompat.app.AlertDialog.Builder alert = new androidx.appcompat.app.AlertDialog.Builder(this);
        alert.setTitle("Alert");
        alert.setMessage(message);
        //anonymous inner class to handle the onClick event of YES or NO.
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "YES", Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void removeSelected(View view) {

    }
}