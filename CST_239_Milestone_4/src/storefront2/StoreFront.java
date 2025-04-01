// --- StoreFront.java ---
package storefront2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Handles user interaction and store functionality.
 */
public class StoreFront {
    private InventoryManager inventoryManager = new InventoryManager();
    private ShoppingCart shoppingCart = new ShoppingCart();

    public void startStore() {
        System.out.println("DEBUG: startStore() has started");

        inventoryManager.initializeInventoryFromFile("data/inventory.json");  
        shoppingCart.initializeCart();                                       

        System.out.println("DEBUG: Called initializeInventoryFromFile()");
        System.out.println("\nInventory Loaded:");
        for (SalableProduct product : inventoryManager.getInventory()) {
            System.out.println("- " + product.getName() + " (" + product.getQuantity() + ") - $" + product.getPrice());
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Store Front!");
            System.out.println("1. View Products\n2. Purchase Product\n3. Cancel Purchase\n4. View Cart\n5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    List<SalableProduct> sortedInventory = new ArrayList<>(inventoryManager.getInventory());
                    sortedInventory.sort(Comparator.comparing(SalableProduct::getName, String.CASE_INSENSITIVE_ORDER));
                    for (SalableProduct product : sortedInventory) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("Enter product name to purchase: ");
                    String purchaseName = scanner.nextLine();
                    boolean foundPurchase = false;
                    for (SalableProduct product : inventoryManager.getInventory()) {
                        if (product.getName().equalsIgnoreCase(purchaseName) && product.getQuantity() > 0) {
                            inventoryManager.removeProduct(product);
                            shoppingCart.addToCart(product);
                            System.out.println("Product purchased and added to cart.");
                            foundPurchase = true;
                            break;
                        }
                    }
                    if (!foundPurchase) System.out.println("Product not found or out of stock.");
                    break;
                case 3:
                    System.out.print("Enter product name to cancel: ");
                    String cancelName = scanner.nextLine();
                    boolean foundCancel = false;
                    for (SalableProduct product : new ArrayList<>(shoppingCart.getCartContents())) {
                        if (product.getName().equalsIgnoreCase(cancelName)) {
                            shoppingCart.removeFromCart(product);
                            inventoryManager.addProduct(product);
                            System.out.println("Purchase canceled and returned to inventory.");
                            foundCancel = true;
                            break;
                        }
                    }
                    if (!foundCancel) System.out.println("Product not found in cart.");
                    break;
                case 4:
                    if (shoppingCart.getCartContents().isEmpty()) {
                        System.out.println("Your cart is empty.");
                    } else {
                        for (SalableProduct product : shoppingCart.getCartContents()) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }

        System.out.println("Thank you for visiting the store!");
    }

    
    public static void main(String[] args) {
        new StoreFront().startStore();  
    }
}
