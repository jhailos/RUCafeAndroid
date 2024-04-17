package com.example.androidrucafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CoffeeActivity extends AppCompatActivity {

    private Spinner quantitySelect;
    private Spinner sizeSelect;

    /**
     * Perform initial setup
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        // initialize quantitySelect spinner listener
        quantitySelect = findViewById(R.id.coffeeQuantitySpinner);
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
        // initialize sizeSelect spinner listener
        sizeSelect = findViewById(R.id.coffeeSizeSpinner);
        sizeSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    /**
     * Get the state of the sweet cream CheckBox
     * @return true if checked
     */
    private boolean getSweetCream() {
        CheckBox checkBox = findViewById(R.id.sweetCreamCheckBox);
        return checkBox.isChecked();
    }

    /**
     * Get the state of the caramel CheckBox
     * @return true if checked
     */
    private boolean getCaramel() {
        CheckBox checkBox = findViewById(R.id.caramelCheckBox);
        return checkBox.isChecked();
    }

    /**
     * Get the state of the french vanilla CheckBox
     * @return true if checked
     */
    private boolean getFrenchVanilla() {
        CheckBox checkBox = findViewById(R.id.frenchVanillaCheckBox);
        return checkBox.isChecked();
    }

    /**
     * Get the state of the mocha CheckBox
     * @return true if checked
     */
    private boolean getMocha() {
        CheckBox checkBox = findViewById(R.id.mochaCheckBox);
        return checkBox.isChecked();
    }

    /**
     * Get the state of the irish cream CheckBox
     * @return true if checked
     */
    private boolean getIrishCream() {
        CheckBox checkBox = findViewById(R.id.irishCreamCheckBox);
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
     * Get the name of the currenty selected size quantity
     * @return name of selected size as a string
     */
    private String getSize() {
        return (String) quantitySelect.getSelectedItem();
    }

    /**
     * Displays the subtotal in GUI
     */
    public void displaySubtotal(View view) {
        Coffee order = new Coffee(getQuantity(), getSize(), getSweetCream(),
                getFrenchVanilla(), getIrishCream(), getCaramel(), getMocha());
        TextView subtotalText = findViewById(R.id.coffeeSubtotalValue);
        subtotalText.setText("$ " + String.valueOf(order.price()));
    }
}
