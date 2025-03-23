package storefront;

import java.util.Scanner;

public class StoreFront {
    private String storeName;
    private InventoryManager inventoryManager;

    public StoreFront(String storeName) {
        this.storeName = storeName;
        this.inventoryManager = new InventoryManager();
        this.inventoryManager.populateInitialInventory();
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to " + storeName + "!");
        System.out.println("Explore and purchase the best items for your adventure.");
    }

    public void showActions() {
        System.out.println("Actions:");
        System.out.println("1. View Inventory");
        System.out.println("2. Purchase Product");
        System.out.println("3. Cancel Purchase");
        System.out.println("4. Exit");
    }

    public void handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showActions();
            System.out.print("Choose an action: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    inventoryManager.listProducts();
                    break;
                case 2:
                    System.out.print("Enter product name to purchase: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (inventoryManager.purchaseProduct(productName, quantity)) {
                        System.out.println("Purchase successful!");
                    } else {
                        System.out.println("Purchase failed. Check product name or quantity.");
                    }
                    break;
                case 3:
                    System.out.print("Enter product name to cancel purchase: ");
                    productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    inventoryManager.cancelPurchaseProduct(productName, quantity);
                    System.out.println("Purchase canceled.");
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for visiting " + storeName + "! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        StoreFront storeFront = new StoreFront("Adventure Gear Store");
        storeFront.displayWelcomeMessage();
        storeFront.handleUserInput();
    }
}
