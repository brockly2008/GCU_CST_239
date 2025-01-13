/**
 * The entry point for the online shopping system application.
 */
package app;

import java.util.List;

/**
 * The StoreFrontStart class initializes the inventory, adds products, and starts the StoreFront interaction.
 */
public class StoreFrontStart {
    /**
     * The main method initializes the application by setting up the inventory, adding products, 
     * and starting user interaction through the StoreFront.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Initialize products
        Product product1 = new Product("Laptop", "A powerful laptop", 1200.00, 10);
        Product product2 = new Product("Phone", "A high-end smartphone", 800.00, 20);
        Product product3 = new Product("Headphones", "Noise-cancelling headphones", 200.00, 15);

        // Add products to inventory
        inventoryManager.addProduct(product1);
        inventoryManager.addProduct(product2);
        inventoryManager.addProduct(product3);

        // Start the store front
        StoreFront storeFront = new StoreFront(inventoryManager);
        storeFront.interact();
    }
}
