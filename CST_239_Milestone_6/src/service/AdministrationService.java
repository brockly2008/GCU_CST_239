package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import storefront2.SalableProduct;
import storefront2.InventoryManager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Handles admin commands sent over the network and updates inventory in the background.
 */
public class AdministrationService implements Runnable {
    private final InventoryManager inventoryManager;
    private final FileService fileService;
    private final int port = 7777;
    private boolean running = true;

    public AdministrationService(InventoryManager inventoryManager, FileService fileService) {
        this.inventoryManager = inventoryManager;
        this.fileService = fileService;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("[AdminService] Listening on port " + port);

            while (running) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("[AdminService] Connection accepted");

                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    String command = in.readLine();
                    System.out.println("[AdminService] Received command: " + command);

                    if ("U".equalsIgnoreCase(command)) {
                        String jsonPayload = in.readLine();
                        handleUpdateCommand(jsonPayload);
                        out.println("Inventory updated.");
                    } else if ("R".equalsIgnoreCase(command)) {
                        String inventoryJson = handleReturnCommand();
                        out.println(inventoryJson);
                    } else {
                        out.println("Invalid command.");
                    }
                } catch (IOException e) {
                    System.err.println("[AdminService] Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("[AdminService] Server failed: " + e.getMessage());
        }
    }

    private void handleUpdateCommand(String jsonPayload) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            SalableProduct[] newProducts = mapper.readValue(jsonPayload, SalableProduct[].class);
            for (SalableProduct product : newProducts) {
                inventoryManager.addProduct(product);
            }
            fileService.saveInventory(inventoryManager.getInventory());
            System.out.println("[AdminService] Inventory updated with new products.");
        } catch (IOException e) {
            System.err.println("[AdminService] Update failed: " + e.getMessage());
        }
    }

    private String handleReturnCommand() {
        try {
            List<SalableProduct> inventory = inventoryManager.getInventory();
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(inventory);
        } catch (IOException e) {
            System.err.println("[AdminService] Failed to serialize inventory.");
            return "[]";
        }
    }

    public void stop() {
        running = false;
    }
}
