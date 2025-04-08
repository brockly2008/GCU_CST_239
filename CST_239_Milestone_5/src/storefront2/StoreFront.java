package storefront2;

import java.util.List;
import java.util.Scanner;

/**
 * Main entry point for the Store Front application.
 */
public class StoreFront {

    private InventoryManager inventoryManager;
    private ShoppingCart shoppingCart;
    private Scanner scanner;

    public StoreFront() {
        this.inventoryManager = new InventoryManager();
        this.shoppingCart = new ShoppingCart();
        this.scanner = new Scanner(System.in);

        // Load inventory from JSON file (adjust path if needed)
        inventoryManager.initializeInventoryFromFile("inventory.json");
    }

    public void run() {
        System.out.println(" Welcome to the Game Store!");

        boolean running = true;
        while (running) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. View Inventory");
            System.out.println("2. Sort Inventory by Name (A-Z)");
            System.out.println("3. Sort Inventory by Name (Z-A)");
            System.out.println("4. Sort Inventory by Price (Low-High)");
            System.out.println("5. Sort Inventory by Price (High-Low)");
            System.out.println("6. View Cart");
            System.out.println("7. Checkout / Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayInventory();
                    promptPurchase();
                    break;
                case "2":
                    inventoryManager.sortByNameAsc();
                    System.out.println("Inventory sorted by name (A-Z).");
                    break;
                case "3":
                    inventoryManager.sortByNameDesc();
                    System.out.println("Inventory sorted by name (Z-A).");
                    break;
                case "4":
                    inventoryManager.sortByPriceAsc();
                    System.out.println("Inventory sorted by price (Low–High).");
                    break;
                case "5":
                    inventoryManager.sortByPriceDesc();
                    System.out.println("Inventory sorted by price (High–Low).");
                    break;
                case "6":
                    shoppingCart.displayCart();
                    break;
                case "7":
                    running = false;
                    System.out.println("✅ Thanks for shopping! Goodbye.");
                    break;
                default:
                    System.out.println("❌ Invalid option.");
            }
        }

        scanner.close();
    }

    private void displayInventory() {
        List<SalableProduct> inventory = inventoryManager.getInventory();

        if (inventory.isEmpty()) {
            System.out.println("⚠️ No items in inventory.");
            return;
        }

        System.out.println("\n--- Store Inventory ---");
        int index = 1;
        for (SalableProduct product : inventory) {
            System.out.println(index + ". " + product);
            index++;
        }
    }

    private void promptPurchase() {
        System.out.print("Enter item number to purchase or 0 to return: ");
        try {
            int selection = Integer.parseInt(scanner.nextLine());
            List<SalableProduct> inventory = inventoryManager.getInventory();

            if (selection == 0) return;

            if (selection >= 1 && selection <= inventory.size()) {
                SalableProduct selected = inventory.get(selection - 1);
                if (selected.getQuantity() > 0) {
                    shoppingCart.addProduct(selected);
                    inventoryManager.removeProduct(selected);
                    System.out.println("✅ Added to cart: " + selected.getName());
                } else {
                    System.out.println("❌ Item out of stock.");
                }
            } else {
                System.out.println("❌ Invalid selection.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input.");
        }
    }

    public static void main(String[] args) {
        new StoreFront().run();
    }
}
