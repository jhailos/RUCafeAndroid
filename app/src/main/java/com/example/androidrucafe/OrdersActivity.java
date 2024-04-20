package com.example.androidrucafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Orders activity controller
 *
 * @author Jason Hailos, Andrew Lin
 */
public class OrdersActivity extends AppCompatActivity {

    /**
     * Perform initial setup
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
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
