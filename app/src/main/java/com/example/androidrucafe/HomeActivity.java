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
import android.widget.TextView;
import android.widget.Toast;

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

    public void goToHomeView(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    /**
     * Display an alert to the user
     */
    private void showAlert(String message) {
        androidx.appcompat.app.AlertDialog.Builder alert = new androidx.appcompat.app.AlertDialog.Builder(this);
        alert.setTitle("Demo the alert dialog.");
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
}