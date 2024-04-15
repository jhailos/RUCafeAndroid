package com.example.androidrucafe;

/**
 * Abstract class for subclasses of menu item types
 *
 * @author Jason Hailos, Andrew Lin
 */

abstract class MenuItem {
    protected int qty;

    /**
     * Default constructor
     */
    public MenuItem() {
        this.qty = 0;
    }

    /**
     * Constructor method to be used by subclasses
     *
     * @param qty
     */
    public MenuItem(int qty) {
        this.qty = qty;
    }

    /**
     * Calculates the summed price of same items
     *
     * @return summed price of same items
     */
    public abstract double price();

    /**
     * Description of item
     *
     * @return item type and description
     */
    @Override
    public abstract String toString();

    /**
     * Determines if two items are the same
     *
     * @param obj
     * @return true if same and false otherwise
     */
    @Override
    public abstract boolean equals(Object obj);

    /**
     * Getter method for the qty of item
     *
     * @return qty
     */
    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
