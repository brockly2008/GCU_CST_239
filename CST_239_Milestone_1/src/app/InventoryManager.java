/**
 * Manages the inventory of products in the store.
 */
package app;

import java.util.Map;
import java.util.HashMap;

/**
 * The InventoryManager class handles adding, checking, and updating product stock levels.
 */
public class InventoryManager {
    private Map<Product, Integer> stock; // Maps products to their available quantities

    /**
     * Constructs an InventoryManager with an empty stock.
     */
    public InventoryManager() {
        stock = new HashMap<>();
    }

    /**
     * Adds a product to the inventory.
     *
     * @param product the product to add
     */
    public void addProduct(Product product) {
        stock.put(product, product.getQuantity());
    }

    /**
     * Checks the stock level of a product.
     *
     * @param product the product to check
     * @return the stock level of the product, or 0 if not in stock
     */
    public int checkStock(Product product) {
        return stock.getOrDefault(product, 0);
    }

    /**
     * Updates the stock level of a product.
     *
     * @param product  the product to update
     * @param quantity the new stock level
     */
    public void updateStock(Product product, int quantity) {
        if (stock.containsKey(product)) {
            stock.put(product, quantity);
            product.setQuantity(quantity);
        }
    }

    /**
     * Retrieves the current stock levels.
     *
     * @return a map of products to their quantities in stock
     */
    public Map<Product, Integer> getStock() {
        return stock;
    }
}
