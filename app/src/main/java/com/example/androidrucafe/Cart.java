package com.example.androidrucafe;

import androidx.databinding.ObservableArrayList;

import java.util.ArrayList;

/**
 * Singleton class
 * Stores global order data to share between activities
 *
 * @author Jason Hailos, Andrew Lin
 */
public class Cart {
    private static Cart instance;

    public static ArrayList<MenuItem> cartList;

    public static ObservableArrayList<Donut> donutOptions = new ObservableArrayList<Donut>();

    public static ArrayList<Order> allOrders = new ArrayList<Order>();

    private Cart() {
        cartList = new ArrayList<>();
    }

    /**
     * Get singleton instance of Cart
     * @return
     */
    public static synchronized Cart getInstance() {
        if (instance == null) instance = new Cart();
        return instance;
    }

    public ObservableArrayList<Donut> getDonutOptions() {
        return donutOptions;
    }

    /**
     * Retrieve user selected options
     * @param types
     * @param flavors
     * @param images
     */
    public void populateOptions(String[] types, String[] flavors, int[] images) {
        donutOptions.clear();

        for (int i = 0; i < types.length; i++) {
            donutOptions.add(new Donut(0, types[i], flavors[i], images[i]));
        }
    }

    /**
     * Calculate the subtotal
     * @return subtotal as a double
     */
    public double findSubTotal() {
        double amt = 0.0;
        for (int i = 0; i < donutOptions.size(); i++) {
            amt = amt + donutOptions.get(i).price();
        }
        return Math.round(amt * Math.pow(10, 2)) / Math.pow(10, 2);
    }
}
