package com.example.androidrucafe;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    /**
     * Perform initial setup
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
}