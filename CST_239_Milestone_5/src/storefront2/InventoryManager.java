package storefront2;

import service.FileService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Manages the store's inventory of SalableProducts.
 */
public class InventoryManager {

    private List<SalableProduct> products;
    private FileService fileService;

    public InventoryManager() {
        this.products = new ArrayList<>();
        this.fileService = new FileService();
    }

    /**
     * Loads inventory from a JSON file.
     */
    public void initializeInventoryFromFile(String filePath) {
        try {
            this.products = fileService.readInventoryFromFile(filePath);
            System.out.println("Inventory loaded successfully from file.");
        } catch (IOException e) {
            System.out.println("Error loading inventory from file: " + e.getMessage());
            this.products = new ArrayList<>();
        }
    }

    /**
     * Returns the list of products.
     */
    public List<SalableProduct> getInventory() {
        return products;
    }

    /**
     * Decreases quantity when a product is purchased.
     */
    public void removeProduct(SalableProduct product) {
        product.setQuantity(product.getQuantity() - 1);
    }

    /**
     * Increases quantity when a product is returned/canceled.
     */
    public void addProduct(SalableProduct product) {
        product.setQuantity(product.getQuantity() + 1);
    }

    // 🔽🔼 SORTING METHODS 🔽🔼

    public void sortByNameAsc() {
        products.sort(Comparator.comparing(SalableProduct::getName, String.CASE_INSENSITIVE_ORDER));
    }

    public void sortByNameDesc() {
        products.sort(Comparator.comparing(SalableProduct::getName, String.CASE_INSENSITIVE_ORDER).reversed());
    }

    public void sortByPriceAsc() {
        products.sort(Comparator.comparingDouble(SalableProduct::getPrice));
    }

    public void sortByPriceDesc() {
        products.sort(Comparator.comparingDouble(SalableProduct::getPrice).reversed());
    }
}
