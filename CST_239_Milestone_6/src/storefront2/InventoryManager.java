package storefront2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Manages inventory operations such as sorting, retrieving, and updating products.
 */
public class InventoryManager {

    private List<SalableProduct> inventory;

    public InventoryManager() {
        this.inventory = new ArrayList<>();
    }

    public List<SalableProduct> getInventory() {
        return inventory;
    }

    public void setInventory(List<SalableProduct> inventory) {
        this.inventory = inventory;
    }

    public void addProduct(SalableProduct product) {
        // If item already exists, update quantity; else, add new
        for (SalableProduct existing : inventory) {
            if (existing.getName().equalsIgnoreCase(product.getName())) {
                existing.setQuantity(existing.getQuantity() + product.getQuantity());
                return;
            }
        }
        inventory.add(product);
    }

    public void removeProduct(SalableProduct product) {
        // Decrease quantity or remove from inventory if quantity hits 0
        for (int i = 0; i < inventory.size(); i++) {
            SalableProduct item = inventory.get(i);
            if (item.getName().equalsIgnoreCase(product.getName())) {
                int newQty = item.getQuantity() - 1;
                if (newQty <= 0) {
                    inventory.remove(i);
                } else {
                    item.setQuantity(newQty);
                }
                break;
            }
        }
    }

    public void sortByNameAsc() {
        inventory.sort(Comparator.comparing(SalableProduct::getName, String.CASE_INSENSITIVE_ORDER));
    }

    public void sortByNameDesc() {
        inventory.sort(Comparator.comparing(SalableProduct::getName, String.CASE_INSENSITIVE_ORDER).reversed());
    }

    public void sortByPriceAsc() {
        inventory.sort(Comparator.comparingDouble(SalableProduct::getPrice));
    }

    public void sortByPriceDesc() {
        inventory.sort(Comparator.comparingDouble(SalableProduct::getPrice).reversed());
    }
}
