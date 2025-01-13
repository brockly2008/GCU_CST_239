/**
 * Represents a salable product in the store.
 */
package app;

/**
 * The Product class defines the attributes and behaviors of a product, including its name,
 * description, price, and quantity in stock.
 */
public class Product {
    private String name; // Name of the product
    private String description; // Description of the product
    private double price; // Price of the product
    private int quantity; // Quantity available in stock

    /**
     * Constructs a Product with the specified attributes.
     *
     * @param name        the name of the product
     * @param description the description of the product
     * @param price       the price of the product
     * @param quantity    the quantity available in stock
     */
    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Gets the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the product.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the quantity available in stock.
     *
     * @return the quantity available in stock
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Updates the quantity of the product.
     *
     * @param quantity the new quantity of the product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets a detailed description of the product.
     *
     * @return a string describing the product
     */
    public String getDetails() {
        return name + ": " + description + " - $" + price + " (" + quantity + " available)";
    }
}
