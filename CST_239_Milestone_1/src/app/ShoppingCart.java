/**
 * Represents a shopping cart for managing selected products and calculating total cost.
 */
package app;

import java.util.Map;
import java.util.HashMap;

/**
 * The ShoppingCart class allows users to add, remove, and manage products in the cart, 
 * as well as calculate the total cost of all items.
 */
public class ShoppingCart {
    private Map<Product, Integer> items; // Maps products to their quantities in the cart

    /**
     * Constructs an empty shopping cart.
     */
    public ShoppingCart() {
        items = new HashMap<>();
    }

    /**
     * Adds a product to the cart with the specified quantity.
     *
     * @param product  the product to add
     * @param quantity the quantity to add
     */
    public void addItem(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            items.put(product, items.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println("Not enough stock for " + product.getName());
        }
    }

    /**
     * Removes a product from the cart.
     *
     * @param product the product to remove
     */
    public void removeItem(Product product) {
        items.remove(product);
    }

    /**
     * Clears all items from the cart.
     */
    public void clearCart() {
        items.clear();
    }

    /**
     * Calculates the total cost of all items in the cart.
     *
     * @return the total cost of the cart
     */
    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    /**
     * Displays the contents of the cart.
     */
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Shopping cart is empty.");
        } else {
            for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                System.out.println(entry.getKey().getName() + " x " + entry.getValue());
            }
            System.out.println("Total: $" + calculateTotal());
        }
    }

    /**
     * Gets the items in the cart.
     *
     * @return a map of products to their quantities in the cart
     */
    public Map<Product, Integer> getItems() {
        return items;
    }
}
