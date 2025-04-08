package storefront2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the user's shopping cart.
 */
public class ShoppingCart {
    private List<SalableProduct> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    /**
     * Adds a product to the shopping cart.
     */
    public void addProduct(SalableProduct product) {
        cartItems.add(product);
    }

    /**
     * Removes a product from the shopping cart.
     */
    public void removeProduct(SalableProduct product) {
        cartItems.remove(product);
    }

    /**
     * Returns the list of products in the cart.
     */
    public List<SalableProduct> getCartItems() {
        return cartItems;
    }

    /**
     * Empties the cart.
     */
    public void clearCart() {
        cartItems.clear();
    }

    /**
     * Checks if the cart is empty.
     */
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    /**
     * Displays cart contents.
     */
    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("🛒 Your cart is empty.");
        } else {
            System.out.println("🛒 Your Shopping Cart:");
            for (SalableProduct item : cartItems) {
                System.out.println("- " + item);
            }
        }
    }
}
