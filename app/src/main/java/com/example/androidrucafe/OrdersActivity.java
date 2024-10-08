package com.example.androidrucafe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Orders activity controller
 *
 * @author Jason Hailos, Andrew Lin
 */
import java.util.ArrayList;

/**
 * Orders activity controller
 *
 * @author Jason Hailos, Andrew Lin
 */
public class OrdersActivity extends AppCompatActivity {

    private ArrayAdapter<Integer> adapterOrders;
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

        adapterOrders = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOrderNums);
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
                        calcTotal(Cart.allOrders.get(i));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Update the menu item adapter
     * @param order
     */
    private void updateMenuItemAdapter(Order order) {
        holder.clear();
        holder.addAll(order.getList());
        adapterMenuItems.notifyDataSetChanged();
    }

    /**
     * Display a toast to the user
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Calculates the total of the selected order
     */
    private void calcTotal(Order order) {
        TextView textView = findViewById(R.id.textView11);
        String display = "Total: " + order.total();
        textView.setText(display);
    }

    /**
     * Populate the order number list
     */
    private void popOrderNumList() {
        listOrderNums.clear();
        for (int i = 0; i < Cart.allOrders.size(); i++) {
            listOrderNums.add(Cart.allOrders.get(i).getNum());
        }
        adapterOrders.notifyDataSetChanged();
    }

    /**
     * Switch to home view
     * @param view
     */
    public void goToHomeView(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    /**
     * Cancel current order
     *
     * @param view
     */
    public void cancelOrder(View view) {
        spinner = findViewById(R.id.ordersSelectPastOrderButton);
        if (Cart.allOrders.isEmpty()) {
            showToast("No orders to cancel.");
            return;
        }
        String value = spinner.getSelectedItem().toString();
        for (int i = 0; i < Cart.allOrders.size(); i++) {
            if (Cart.allOrders.get(i).getNum() == Integer.parseInt(value)) {
                Cart.allOrders.remove(i);
                listOrderNums.remove(i);
                holder.clear();
                adapterOrders.notifyDataSetChanged();
                adapterMenuItems.notifyDataSetChanged();
            }
        }
        spinner.setSelection(0);
        if (!listOrderNums.isEmpty()) {
            value = spinner.getSelectedItem().toString();
            for (int i = 0; i < Cart.allOrders.size(); i++) {
                if (Cart.allOrders.get(i).getNum() == Integer.valueOf(value)) {
                    updateMenuItemAdapter(Cart.allOrders.get(i));
                    calcTotal(Cart.allOrders.get(i));
                }
            }
        }
        else {
            calcTotal(new Order());
        }
    }
}
