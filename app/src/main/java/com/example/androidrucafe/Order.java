package rucafe;

import java.util.ArrayList;

/**
 * Class for each order
 *
 * @author Jason Hailos, Andrew Lin
 */

public class Order {
    private ArrayList<MenuItem> orderItems;
    private int orderNum;

    private static int counter = 1;
    private static final double TAX_PERCENT = 0.0665;

    /**
     * Constructor for an instance of Order class
     */
    public Order() {
        this.orderItems = new ArrayList<MenuItem>();
        this.orderNum = counter;
        counter++;
    }

    /**
     * Calculates subtotal of order
     *
     * @return subtotal
     */
    public double subtotal() {
        double sum = 0.0;
        for (MenuItem i : orderItems) {
            sum = sum + i.price();
        }
        return sum;
    }

    /**
     * Calculates sales tax of an order
     *
     * @return sales tax amount
     */
    public double salesTax() {
        double tax = this.subtotal() * TAX_PERCENT;
        return Math.round(tax * Math.pow(10, 2)) / Math.pow(10, 2); //rounds to two decimals
    }

    /**
     * Calculates the total of an order
     *
     * @return total of order
     */
    public double total() {
        double total = this.subtotal() + this.salesTax();
        return Math.round(total * Math.pow(10, 2)) / Math.pow(10, 2); //rounds to two decimals;
    }

    /**
     * Getter method for the ArrayList of menu items
     *
     * @return list of items
     */
    public ArrayList<MenuItem> getList() {
        return this.orderItems;
    }

    /**
     * Getter method for number of the order
     *
     * @return order number
     */
    public int getNum() {
        return this.orderNum;
    }

    /**
     * Generates a descriptive string of the order and its items
     *
     * @return descriptive string of the order
     */
    @Override
    public String toString() {
        String items = "";
        for (MenuItem i : orderItems) {
            items = items + " - " + i.toString() + "\n";
        }
        return "Order No. " + orderNum + "\n" +
                "**subtotal $" + subtotal() + "\n" +
                "**sales tax $" + salesTax() + "\n" +
                "**total $" + total() + "\n" +
                items;
    }
}
