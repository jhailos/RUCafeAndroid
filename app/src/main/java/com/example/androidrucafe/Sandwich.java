package com.example.androidrucafe;

/**
 * Subclass of MenuItem class for the item sandwich
 *
 * @author Jason Hailos, Andrew Lin
 */
public class Sandwich extends MenuItem{
    private String protein;
    private String bread;
    private boolean cheese;
    private boolean lettuce;
    private boolean tomatoes;
    private boolean onions;

    private static final double BEEF_PRICE = 10.99;
    private static final double CHICKEN_PRICE = 8.99;
    private static final double FISH_PRICE = 9.99;
    private static final double CHEESE_PRICE = 1.00;
    private static final double VEGGIE_PRICE = 0.30;

    /**
     * Constructor for an instance of Sandwich class
     *
     * @param qty
     * @param protein
     * @param bread
     * @param cheese
     * @param lettuce
     * @param tomatoes
     * @param onions
     */

    /**
     * Default constructor
     */
    public Sandwich() {
        super();
        this.protein = null;
        this.bread = null;
        this.cheese = false;
        this.lettuce = false;
        this.tomatoes = false;
        this.onions = false;
    }

    /**
     * Constructor
     * @param qty
     * @param protein
     * @param bread
     * @param cheese
     * @param lettuce
     * @param tomatoes
     * @param onions
     */
    public Sandwich(int qty, String protein, String bread, boolean cheese,
                    boolean lettuce, boolean tomatoes, boolean onions) {
        super(qty);
        this.protein = protein;
        this.bread = bread;
        this.cheese = cheese;
        this.lettuce = lettuce;
        this.tomatoes = tomatoes;
        this.onions = onions;
    }

    /**
     * Counts the number of veggie add-ons
     *
     * @return int of veggie add-ons
     */
    private int countVeggieAddOns() {
        int count = 0;
        if (lettuce) {
            count++;
        }
        if (tomatoes) {
            count++;
        }
        if (onions) {
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
        double sum = 0.0;
        if (protein.equalsIgnoreCase("BEEF")) {
            sum = BEEF_PRICE;
        }
        if (protein.equalsIgnoreCase("CHICKEN")) {
            sum = CHICKEN_PRICE;
        }
        if (protein.equalsIgnoreCase("FISH")) {
            sum = FISH_PRICE;
        }

        if (cheese) {
            sum = sum + CHEESE_PRICE;
        }
        sum = (sum + countVeggieAddOns() * VEGGIE_PRICE) * qty;
        //rounds to two decimal place because of the nature of doubles
        return Math.round(sum * Math.pow(10, 2)) / Math.pow(10, 2);
    }

    /**
     * Generates a descriptive string of add-ons for the sandwich
     *
     * @return descriptive string of "with..."
     */
    public String addOnDescription() {
        String description = "with";
        if (cheese) {
            description = description + " cheese,";
        }
        if (lettuce) {
            description = description + " lettuce,";
        }
        if (tomatoes) {
            description = description + " tomatoes,";
        }
        if (onions) {
            description = description + " onions,";
        }

        if (description.equals("with")) {
            description = description + " no add-ons";
        }
        else {
            description = description.substring(0, description.length() - 1);
        }
        return description;
    }

    /**
     * Description of item
     *
     * @return item type and description
     */
    @Override
    public String toString() {
        return "(" + this.qty + ") " + this.bread + " bread and "+ this.protein +
                " sandwich " + this.addOnDescription();
    }

    /**
     * Determines if two items are the same
     *
     * @param obj
     * @return true if same and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sandwich sandwich) {
            return sandwich.getBread().equals(this.getBread()) &&
                    sandwich.getProtein().equals(this.getProtein()) &&
                    sandwich.getCheese() == this.getCheese() &&
                    sandwich.getLettuce() == this.getLettuce() &&
                    sandwich.getTomatoes() == this.getTomatoes() &&
                    sandwich.getOnions() == this.getOnions();
        }
        return false;
    }

    /**
     * Getter method for type of bread
     *
     * @return string of the bread type
     */
    public String getBread() {
        return this.bread;
    }

    /**
     * Getter method for type of protein
     *
     * @return string of the protein type
     */
    public String getProtein() {
        return this.protein;
    }

    /**
     * Getter method for add-on name in signature
     *
     * @return true if added
     */
    public boolean getCheese() {
        return this.cheese;
    }

    /**
     * Getter method for add-on name in signature
     *
     * @return true if added
     */
    public boolean getLettuce() {
        return this.lettuce;
    }

    /**
     * Getter method for add-on name in signature
     *
     * @return true if added
     */
    public boolean getTomatoes() {
        return this.tomatoes;
    }

    /**
     * Getter method for add-on name in signature
     *
     * @return true if added
     */
    public boolean getOnions() {
        return this.onions;
    }

    /**
     * Setter method for protein
     * @param protein
     */
    public void setProtein(String protein) {
        this.protein = protein;
    }

    /**
     * Setter method for bread
     * @param bread
     */
    public void setBread(String bread) {
        this.bread = bread;
    }

    /**
     * Setter method for cheese
     * @param cheese
     */
    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    /**
     * Setter method for lettuce
     * @param lettuce
     */
    public void setLettuce(boolean lettuce) {
        this.lettuce = lettuce;
    }

    /**
     * Setter method for tomatoes
     * @param tomatoes
     */
    public void setTomatoes(boolean tomatoes) {
        this.tomatoes = tomatoes;
    }

    /**
     * Setter method for onions
     * @param onions
     */
    public void setOnions(boolean onions) {
        this.onions = onions;
    }
}
