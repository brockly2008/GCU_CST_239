// --- InventoryManager.java ---
package storefront2;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import service.FileService;

/**
 * Manages the store's inventory.
 */
public class InventoryManager {
    private List<SalableProduct> products;
    private FileService fileService;

    public InventoryManager() {
        this.fileService = new FileService();
        this.products = new ArrayList<>();
    }

    public void initializeInventoryFromFile(String filePath) {
        try {
            this.products = fileService.readInventoryFromFile(filePath);
            System.out.println("Inventory loaded successfully from file.");
        } catch (IOException e) {
            System.out.println("Error loading inventory from file: " + e.getMessage());
            this.products = new ArrayList<>();
        }
    }

    public List<SalableProduct> getInventory() {
        return products;
    }

    public void removeProduct(SalableProduct product) {
        product.setQuantity(product.getQuantity() - 1);
    }

    public void addProduct(SalableProduct product) {
        product.setQuantity(product.getQuantity() + 1);
    }
}
