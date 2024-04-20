package com.example.androidrucafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Donut activity controller
 *
 * @author Jason Hailos, Andrew Lin
 */
public class DonutActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DonutAdaptor adaptor;
    private ArrayList<Donut> cartItems = new ArrayList<Donut>();
    private ArrayAdapter<Donut> cartItemAdaptor;

    /**
     * Perform initial setup
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);

        RecyclerView recyclerView = findViewById(R.id.donutMenuRecyclerView);

        setUpDonutArray();

        adaptor = new DonutAdaptor(this, Cart.getInstance().getDonutOptions());
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ListView listView = findViewById(R.id.cartItemsListView);
        cartItemAdaptor = new ArrayAdapter<Donut>(this, android.R.layout.simple_list_item_1, cartItems);
        listView.setAdapter(cartItemAdaptor);
        listView.setOnItemClickListener(this);
    }

    /**
     * Display a toast to the user
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
        cartItems.get(i).setQty(0);
        Cart.getInstance().getDonutOptions().add(cartItems.get(i));
        adaptor.notifyDataSetChanged();
        cartItems.remove(i);
        cartItemAdaptor.notifyDataSetChanged();

        calcSubTotal();
    }

    /**
     * Calculate the subtotal and display it to GUI
     */
    private void calcSubTotal() {
        double total = 0.0;
        for (int i = 0; i < cartItems.size(); i ++) {
            total = total + cartItems.get(i).price();
        }
        total = Math.round(total * Math.pow(10, 2)) / Math.pow(10, 2);

        String display = "sub-total: " + total;
        TextView textView = findViewById(R.id.donutSubTotalTextView);
        textView.setText(display);
    }

    /**
     * Add selected donuts to donut cart
     * @param view
     */
    public void addToDonutCart(View view) {
        for (int i = 0; i < Cart.getInstance().getDonutOptions().size(); i++) {
            if (Cart.getInstance().getDonutOptions().get(i).getQty() != 0) {
                cartItems.add(Cart.getInstance().getDonutOptions().get(i));
                Cart.getInstance().getDonutOptions().remove(i);
                i--;
            }
        }
        adaptor.notifyDataSetChanged();
        cartItemAdaptor.notifyDataSetChanged();

        calcSubTotal();
    }

    /**
     * Switch to home view
     * @param view
     */
    public void goToHomeView(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    int[] donutImages = {R.drawable.yeast_plain, R.drawable.yeast_choco, R.drawable.yeast_vanilla,
            R.drawable.yeast_mocha, R.drawable.yeast_ube, R.drawable.yeast_glazed, R.drawable.cake_mocha,
            R.drawable.cake_ube, R.drawable.cake_glazed, R.drawable.hole_plain, R.drawable.hole_choco,
            R.drawable.hole_vanilla};

    /**
     * Helper method to prepare donut array
     */
    private void setUpDonutArray() {
        String[] donutTypes = getResources().getStringArray(R.array.donut_type);
        String[] donutFlavor = getResources().getStringArray(R.array.donut_flavor);

        Cart.getInstance().populateOptions(donutTypes, donutFlavor, donutImages);
    }

    /**
     * Add order in donut cart to home cart
     * @param view
     */
    public void donutAddToOrder(View view) {
        if(cartItems.isEmpty()) showToast("Cart is empty");
        while (!cartItems.isEmpty()) {
            Cart.getInstance().cartList.add(cartItems.get(0).duplicate());
            cartItems.get(0).setQty(0);
            Cart.getInstance().getDonutOptions().add(cartItems.get(0));
            cartItems.remove(0);
            adaptor.notifyDataSetChanged();
            cartItemAdaptor.notifyDataSetChanged();
            showToast("Added to cart");
        }

        calcSubTotal();
    }
}