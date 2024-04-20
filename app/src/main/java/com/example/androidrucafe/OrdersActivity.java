package com.example.androidrucafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Orders activity controller
 *
 * @author Jason Hailos, Andrew Lin
 */
import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {

    private ArrayAdapter<Order> adapterOrders;
    private ArrayList<Integer> listOrderNums = new ArrayList<Integer>();
    private ArrayAdapter<MenuItem> adapterMenuItems;
    private ArrayList<MenuItem> holder = new ArrayList<MenuItem>();
    private ListView listview;
    private Spinner spinner;

    /**
     * Perform initial setup
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        adapterMenuItems = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, holder);
        listview = findViewById(R.id.ordersListView);
        listview.setAdapter(adapterMenuItems);

        popOrderNumList();
        spinner = findViewById(R.id.ordersSelectPastOrderButton);
        spinner.setAdapter(adapterOrders);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                for (int i = 0; i < Cart.allOrders.size(); i++) {
                    if (Cart.allOrders.get(i).getNum() == Integer.valueOf(item)) {
                        updateMenuItemAdapter(Cart.allOrders.get(i));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void updateMenuItemAdapter(Order order) {
        holder.clear();
        for (int i = 0; i < order.getList().size(); i++) {
            holder.add(order.getList().get(i));
        }
        adapterMenuItems.notifyDataSetChanged();
    }

    private void popOrderNumList() {
        listOrderNums.clear();
        for (int i = 0; i < Cart.allOrders.size(); i++) {
            listOrderNums.add(Cart.allOrders.get(i).getNum());
        }
    }

    /**
     * Switch to home view
     * @param view
     */
    public void goToHomeView(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
