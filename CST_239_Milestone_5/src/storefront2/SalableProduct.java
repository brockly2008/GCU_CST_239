package storefront2;

/**
 * Abstract base class for all salable products.
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
        return String.format("%s - %s | $%.2f | Qty: %d", name, description, price, quantity);
    }
}
