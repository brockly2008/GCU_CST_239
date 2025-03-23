package storefront;

public class SalableProduct {
    private String name;
    private String description;
    private double price;
    private int quantity;

    public SalableProduct(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean purchase(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            return true;
        } else {
            return false;
        }
    }

    public void cancelPurchase(int quantity) {
        this.quantity += quantity;
    }
}
