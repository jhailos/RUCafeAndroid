package com.example.androidrucafe;

import androidx.databinding.ObservableArrayList;

import java.util.ArrayList;

/**
 * Singleton class
 * Stores global order data to share between activities
 */
public class Cart {
    private static Cart instance;

    public static ArrayList<MenuItem> cartList;

    public static ObservableArrayList<Donut> donutOptions = new ObservableArrayList<Donut>();

    private Cart() {
        cartList = new ArrayList<>();
    }

    public static synchronized Cart getInstance() {
        if (instance == null) instance = new Cart();
        return instance;
    }

    public ObservableArrayList<Donut> getDonutOptions() {
        return donutOptions;
    }

    public void populateOptions(String[] types, String[] flavors, int[] images) {
        for (int i = 0; i < types.length; i++) {
            donutOptions.add(new Donut(0, types[i], flavors[i], images[i]));
        }
    }
}
