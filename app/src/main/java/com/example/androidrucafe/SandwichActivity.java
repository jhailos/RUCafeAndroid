package com.example.androidrucafe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SandwichActivity extends AppCompatActivity {
    private Spinner quantitySelect;

    /**
     * Perform initial setup
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich);
        // initialize quantitySelect spinner listener
        quantitySelect = findViewById(R.id.sandwichQuantitySelect);
        quantitySelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                displaySubtotal(view);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                // do nothing
            }
        });
    }

    public void goToHomeView(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    /**
     * Display a toast to the user
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * get a string of the currently selected bread option
     * @return
     */
    private String getBread() {
        RadioGroup radioGroup = findViewById(R.id.breadRadioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        if (selectedRadioButton == null) return null;
        return selectedRadioButton.getText().toString();
    }

    /**
     * get a string of the currently selected protein option
     * @return
     */
    private String getProtein() {
        RadioGroup radioGroup = findViewById(R.id.proteinRadioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        if (selectedRadioButton == null) return null;
        return selectedRadioButton.getText().toString();
    }

    /**
     * Get the state of the cheese CheckBox
     * @return true if checked
     */
    private boolean getCheese() {
        CheckBox checkBox = findViewById(R.id.cheese);
        return checkBox.isChecked();
    }

    /**
     * Get the state of the lettuce CheckBox
     * @return true if checked
     */
    private boolean getLettuce() {
        CheckBox checkBox = findViewById(R.id.lettuce);
        return checkBox.isChecked();
    }

    /**
     * Get the state of the tomato CheckBox
     * @return true if checked
     */
    private boolean getTomato() {
        CheckBox checkBox = findViewById(R.id.tomato);
        return checkBox.isChecked();
    }

    /**
     * Get the state of the onion CheckBox
     * @return true if checked
     */
    private boolean getOnion() {
        CheckBox checkBox = findViewById(R.id.onion);
        return checkBox.isChecked();
    }

    /**
     * Get an integer of the currenty selected order quantity
     * @return
     */
    private int getQuantity() {
        return Integer.parseInt((String) quantitySelect.getSelectedItem());
    }

    /**
     * Check if the order is missing necessary fields to calculate
     * a subtotal or place an order.
     * @return true if missing necessary fields (bread, protein, quantity)
     */
    private boolean missingNecessaryFields() {
        if (getBread() == null) return true;
        if (getProtein() == null) return true;
        return false;
    }

    /**
     * Displays the subtotal in GUI
     */
    public void displaySubtotal(View view) {
        if (missingNecessaryFields()) return; // can't calculate, missing info
        Sandwich order = new Sandwich(getQuantity(), getProtein(), getBread(), getCheese(),
                getLettuce(), getTomato(), getOnion());
        TextView subtotalText = findViewById(R.id.sandwichSubtotalValue);
        subtotalText.setText("$ " + String.valueOf(order.price()));
    }

    public void addToOrder(View view) {
        if (missingNecessaryFields()) {
            showToast(getString(R.string.missingFieldsError));
            return;
        }
        Sandwich order = new Sandwich(getQuantity(), getProtein(), getBread(), getCheese(),
                getLettuce(), getTomato(), getOnion());
        Cart.cartList.add(order);
    }
}
