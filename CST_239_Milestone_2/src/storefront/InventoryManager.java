package storefront;

import java.util.*;

public class InventoryManager {
    private List<SalableProduct> products = new ArrayList<>();

    public void populateInitialInventory() {
        products.add(new Weapon("Sword", "Sharp steel blade", 100.0, 10, 50));
        products.add(new Weapon("Bow", "Long-range weapon", 80.0, 15, 30));
        products.add(new Armor("Shield", "Protective shield", 50.0, 20, 40));
        products.add(new Armor("Helmet", "Sturdy helmet", 30.0, 25, 20));
        products.add(new Health("Potion", "Healing potion", 10.0, 50, 20));
    }

    public void listProducts() {
        System.out.println("Available Products:");
        for (SalableProduct product : products) {
            System.out.printf("- %s: %s ($%.2f, Quantity: %d)%n", product.getName(), product.getDescription(), product.getPrice(), product.getQuantity());
        }
    }

    public SalableProduct findProductByName(String name) {
        for (SalableProduct product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public boolean purchaseProduct(String name, int quantity) {
        SalableProduct product = findProductByName(name);
        if (product != null) {
            return product.purchase(quantity);
        }
        return false;
    }

    public void cancelPurchaseProduct(String name, int quantity) {
        SalableProduct product = findProductByName(name);
        if (product != null) {
            product.cancelPurchase(quantity);
        }
    }
}
