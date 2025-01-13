/**
 * Represents the store front where users can interact with the shopping system.
 */
package app;

import java.util.Map;
import java.util.Scanner;

/**
 * The StoreFront class manages user interaction, allowing browsing of products,
 * adding items to a shopping cart, and completing or canceling purchases.
 */
public class StoreFront {
    private InventoryManager inventoryManager; // Manages inventory
    private ShoppingCart shoppingCart; // Manages the user's shopping cart

    /**
     * Constructs a StoreFront with the specified inventory manager.
     *
     * @param inventoryManager the inventory manager to use
     */
    public StoreFront(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.shoppingCart = new ShoppingCart();
    }

    /**
     * Displays the available products in the store.
     */
    public void displayProducts() {
        System.out.println("Available Products:");
        for (Product product : inventoryManager.getStock().keySet()) { // Use getter
            System.out.println(product.getDetails());
        }
    }

    /**
     * Facilitates user interaction with the store front, allowing them to browse products,
     * add items to their cart, view the cart, and perform checkout or cancellation operations.
     */
    public void interact() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("\nOptions: browse | add | cart | checkout | cancel | exit");
            System.out.print("Enter your choice: ");
            input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "browse":
                    displayProducts();
                    break;
                case "add":
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    Product product = inventoryManager.getStock().keySet()
                            .stream()
                            .filter(p -> p.getName().equalsIgnoreCase(name))
                            .findFirst()
                            .orElse(null);

                    if (product == null) {
                        System.out.println("Product not found.");
                    } else {
                        System.out.print("Enter quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        shoppingCart.addItem(product, quantity);
                    }
                    break;
                case "cart":
                    shoppingCart.displayCart();
                    break;
                case "checkout":
                    for (Map.Entry<Product, Integer> entry : shoppingCart.getItems().entrySet()) { // Use getter
                        Product cartProduct = entry.getKey();
                        int cartQuantity = entry.getValue();
                        int stockQuantity = inventoryManager.checkStock(cartProduct);

                        if (cartQuantity > stockQuantity) {
                            System.out.println("Insufficient stock for " + cartProduct.getName());
                            return;
                        }
                    }
                    for (Map.Entry<Product, Integer> entry : shoppingCart.getItems().entrySet()) { // Use getter
                        Product cartProduct = entry.getKey();
                        int newQuantity = cartProduct.getQuantity() - entry.getValue();
                        inventoryManager.updateStock(cartProduct, newQuantity);
                    }
                    System.out.println("Purchase confirmed!");
                    shoppingCart.clearCart();
                    break;
                case "cancel":
                    shoppingCart.clearCart();
                    System.out.println("Purchase canceled.");
                    break;
                case "exit":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
