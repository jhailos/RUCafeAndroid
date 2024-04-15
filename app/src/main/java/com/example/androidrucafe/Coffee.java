package com.example.androidrucafe;

/**
 * Subclass of MenuItem class for the item coffee
 *
 * @author Jason Hailos, Andrew Lin
 */

public class Coffee extends MenuItem {
    private String size;
    private boolean sweetCream;
    private boolean frenchVanilla;
    private boolean irishCream;
    private boolean caramel;
    private boolean mocha;

    private static final double ADD_IN = 0.3;
    private static final double CUP_SIZE = 0.5;
    private static final double BASE = 1.99;

    /**
     * Default constructor
     */
    public Coffee() {
        super();
        this.size = null;
        this.sweetCream = false;
        this.frenchVanilla = false;
        this.irishCream = false;
        this.caramel = false;
        this.mocha = false;
    }

    /**
     * Constructor method for an instance of the Coffee class
     *
     * @param qty
     * @param size
     * @param sweetCream
     * @param frenchVanilla
     * @param irishCream
     * @param caramel
     * @param mocha
     */
    public Coffee(int qty, String size, boolean sweetCream, boolean frenchVanilla,
                  boolean irishCream, boolean caramel, boolean mocha) {
        super(qty);
        this.size = size;
        this.sweetCream = sweetCream;
        this.frenchVanilla = frenchVanilla;
        this.irishCream = irishCream;
        this.caramel = caramel;
        this.mocha = mocha;
    }

    /**
     * Counts value of size beginning at 0 for short
     *
     * @return int value of size
     */
    private int countSize() {
        if (this.size.equalsIgnoreCase("SHORT")) {
            return 0;
        }
        if (this.size.equalsIgnoreCase("TALL")) {
            return 1;
        }
        if (this.size.equalsIgnoreCase("GRANDE")) {
            return 2;
        }
        return 3; //for Venti size or other;
    }

    /**
     * Counts how many add-ins there are
     *
     * @return int of add-ins
     */
    private int countAddOn() {
        int count = 0;
        if (sweetCream) {
            count++;
        }
        if (frenchVanilla) {
            count++;
        }
        if (irishCream) {
            count++;
        }
        if (caramel) {
            count++;
        }
        if (mocha) {
            count++;
        }
        return count;
    }

    /**
     * Calculates the summed price of same items
     *
     * @return summed price of same items
     */
    @Override
    public double price() {
        double sum = (BASE + countAddOn() * ADD_IN +
                this.countSize() * CUP_SIZE) * this.qty;

        //rounds to two decimal place because of the nature of doubles
        return Math.round(sum * Math.pow(10, 2)) / Math.pow(10, 2);
    }

    /**
     * Creates description of add-ins
     *
     * @return String of add-ins
     */
    private String addInDescription() {
        String description = "with";
        if (sweetCream) {
            description = description + " sweet cream,";
        }
        if (frenchVanilla) {
            description = description + " french vanilla,";
        }
        if (irishCream) {
            description = description + " Irish cream,";
        }
        if (caramel) {
            description = description + " caramel,";
        }
        if (mocha) {
            description = description + " mocha,";
        }

        if (description.equals("with")) {
            description = description + " no add-ins";
        }
        else {
            //removal of ending comma
            description = description.substring(0, description.length() - 1);
        }
        return description;
    }

    /**
     * Constructs a descriptive string of the order item
     *
     * @return String in format of "(1) grande coffee with ..."
     */
    @Override
    public String toString() {
        return "(" + this.qty + ") " + this.size +
                " coffee " + this.addInDescription();
    }

    /**
     * Determines if two coffees are the same
     *
     * @param obj
     * @return true if same and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coffee coffee) {
            return coffee.getSize().equals(this.getSize()) &&
                    coffee.getSweetCream() == this.getSweetCream() &&
                    coffee.getFrenchVanilla() == this.getFrenchVanilla() &&
                    coffee.getIrishCream() == this.getIrishCream() &&
                    coffee.getCaramel() == this.getCaramel() &&
                    coffee.getMocha() == this.getMocha();
        }
        return false;
    }

    /**
     * Getter method for size
     *
     * @return String of the size
     */
    public String getSize() {
        return this.size;
    }

    /**
     * Getter method for add-on name in signature
     *
     * @return true if added
     */
    public boolean getSweetCream() {
        return this.sweetCream;
    }

    /**
     * Getter method for add-on name in signature
     *
     * @return true if added
     */
    public boolean getFrenchVanilla() {
        return this.frenchVanilla;
    }

    /**
     * Getter method for add-on name in signature
     *
     * @return true if added
     */
    public boolean getIrishCream() {
        return this.irishCream;
    }

    /**
     * Getter method for add-on name in signature
     *
     * @return true if added
     */
    public boolean getCaramel() {
        return this.caramel;
    }

    /**
     * Getter method for add-on name in signature
     *
     * @return true if added
     */
    public boolean getMocha() {
        return this.mocha;
    }

    /**
     * set size
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * set sweet cream
     * @param sweetCream
     */
    public void setSweetCream(boolean sweetCream) {
        this.sweetCream = sweetCream;
    }

    /**
     * set french vanilla
     * @param frenchVanilla
     */
    public void setFrenchVanilla(boolean frenchVanilla) {
        this.frenchVanilla = frenchVanilla;
    }

    /**
     * set irish cream
     */
    public void setIrishCream(boolean irishCream) {
        this.irishCream = irishCream;
    }

    /**
     * set caramel
     * @param caramel
     */
    public void setCaramel(boolean caramel) {
        this.caramel = caramel;
    }

    /**
     * set mocha
     */
    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }
}
