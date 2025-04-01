// --- SalableProduct.java ---
package storefront2;

/**
 * Abstract class representing a product that can be sold in the store.
 */
public abstract class SalableProduct {
    protected String name;
    protected String description;
    protected double price;
    protected int quantity;

    public SalableProduct(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return name + " - " + description + " ($" + price + ") x" + quantity;
    }
}