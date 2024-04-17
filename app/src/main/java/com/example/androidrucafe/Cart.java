package com.example.androidrucafe;

import java.util.ArrayList;

/**
 * Singleton class
 * Stores global order data to share between activities
 */
public class Cart {
    private static Cart instance;

    public static ArrayList<MenuItem> cartList;

    private Cart() {
        cartList = new ArrayList<>();
    }

    public static synchronized Cart getInstance() {
        if (instance == null) instance = new Cart();
        return instance;
    }
}
