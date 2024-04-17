package com.example.androidrucafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DonutActivity extends AppCompatActivity {

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

        DonutAdaptor adaptor = new DonutAdaptor(this, Cart.getInstance().getDonutOptions());
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    int[] donutImages = {R.drawable.yeast_plain, R.drawable.yeast_choco, R.drawable.yeast_vanilla,
            R.drawable.yeast_mocha, R.drawable.yeast_ube, R.drawable.yeast_glazed, R.drawable.cake_mocha,
            R.drawable.cake_ube, R.drawable.cake_glazed, R.drawable.hole_plain, R.drawable.hole_choco,
            R.drawable.hole_vanilla};

    private void setUpDonutArray() {
        String[] donutTypes = getResources().getStringArray(R.array.donut_type);
        String[] donutFlavor = getResources().getStringArray(R.array.donut_flavor);

        Cart.getInstance().populateOptions(donutTypes, donutFlavor, donutImages);
    }

    public void calcSubTotal() {
        double sum = 0.0;
        for (int i = 0; i < Cart.getInstance().getDonutOptions().size(); i++) {
            sum = sum + Cart.getInstance().getDonutOptions().get(i).price();
        }
        String display = "sub-total: " + sum;
        TextView textView = findViewById(R.id.donutSubTotalTextView);
        textView.setText(display);
    }
}
