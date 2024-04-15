package rucafe;

/**
 * Subclass of MenuItem class for the item donut
 *
 * @author Jason Hailos, Andrew Lin
 */

public class Donut extends MenuItem{
    private String type; //donut type can only be "yeast", "cake", or "hole" (GUI ensured)
    private String flavor;
    private static final double YEAST_PRICE = 1.79;
    private static final double CAKE_PRICE = 1.89;
    private static final double HOLE_PRICE = 0.39;

    /**
     * Constructor method for an instance of the Donut class
     *
     * @param qty
     * @param type
     * @param flavor
     */
    public Donut(int qty, String type, String flavor) {
        super(qty);
        this.type = type;
        this.flavor = flavor;
    }

    /**
     * Calculates the summed price of same items
     *
     * @return summed price of same items
     */
    @Override
    public double price() {
        double sum = 9999.0;
        if (this.type.equalsIgnoreCase("YEAST")) {
            sum = YEAST_PRICE * this.qty;
        }
        if (this.type.equalsIgnoreCase("CAKE")) {
            sum = CAKE_PRICE * this.qty;
        }
        if (this.type.equalsIgnoreCase("HOLE")) {
            sum = HOLE_PRICE * this.qty;
        }
        //rounds to two decimal place because of the nature of doubles
        return Math.round(sum * Math.pow(10, 2)) / Math.pow(10, 2);
    }

    /**
     * Turns information of the donut into a String
     *
     * @return String in format of... (1) yeast donut - plain
     */
    @Override
    public String toString() {
        return "(" + qty + ") " + type + " donut - " + flavor;
    }

    /**
     * Determines if donuts are the same
     *
     * @param obj
     * @return true if same type and same flavor -- false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Donut donut) {
            return donut.getType().equals(this.getType())
                    && donut.getFlavor().equals(this.getFlavor());
        }
        return false;
    }

    /**
     * Getter method for the type of the donut
     *
     * @return type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Getter method for the type of flavor
     *
     * @return flavor
     */
    public String getFlavor() {
        return this.flavor;
    }
}
