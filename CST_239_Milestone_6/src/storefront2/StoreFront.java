package storefront2;

import service.AdministrationService;
import service.FileService;

import java.util.List;
import java.util.Scanner;

public class StoreFront {

    private InventoryManager inventoryManager;
    private ShoppingCart shoppingCart;
    private Scanner scanner;
    private FileService fileService;

    public StoreFront() {
        this.inventoryManager = new InventoryManager();
        this.shoppingCart = new ShoppingCart();
        this.scanner = new Scanner(System.in);
        this.fileService = new FileService();

        inventoryManager.setInventory(fileService.loadInventory());
    }

    public void run() {
        AdministrationService adminService = new AdministrationService(inventoryManager, fileService);
        Thread adminThread = new Thread(adminService);
        adminThread.setDaemon(true);
        adminThread.start();

        System.out.println("Welcome to the Game Store!");

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
                    break;
                case "3":
                    inventoryManager.sortByNameDesc();
                    break;
                case "4":
                    inventoryManager.sortByPriceAsc();
                    break;
                case "5":
                    inventoryManager.sortByPriceDesc();
                    break;
                case "6":
                    shoppingCart.displayCart();
                    break;
                case "7":
                    running = false;
                    System.out.println("Thanks for shopping! Goodbye.");
                    break;
                default:
                    System.out.println("[Invalid option]");
            }
        }

        scanner.close();
    }

    private void displayInventory() {
        List<SalableProduct> inventory = inventoryManager.getInventory();
        if (inventory.isEmpty()) {
            System.out.println("[No items in inventory]");
            return;
        }

        int index = 1;
        for (SalableProduct item : inventory) {
            System.out.println(index++ + ". " + item);
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
                    System.out.println("Added to cart: " + selected.getName());
                } else {
                    System.out.println("[Out of stock]");
                }
            } else {
                System.out.println("[Invalid selection]");
            }
        } catch (NumberFormatException e) {
            System.out.println("[Invalid input]");
        }
    }

    public static void main(String[] args) {
        new StoreFront().run();
    }
}
