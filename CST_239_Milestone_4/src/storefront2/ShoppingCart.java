// --- ShoppingCart.java ---
package storefront2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user's shopping cart.
 */
public class ShoppingCart {
    private List<SalableProduct> cartItems = new ArrayList<>();

    public void initializeCart() {
        cartItems.clear();
    }

    public void addToCart(SalableProduct product) {
        cartItems.add(product);
    }

    public void removeFromCart(SalableProduct product) {
        cartItems.remove(product);
    }

    public List<SalableProduct> getCartContents() {
        return cartItems;
    }

    public void emptyCart() {
        cartItems.clear();
    }
}