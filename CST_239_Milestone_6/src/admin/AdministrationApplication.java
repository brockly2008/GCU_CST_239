package admin;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class AdministrationApplication {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 7777);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("=== Admin Console ===");

            boolean running = true;
            while (running) {
                System.out.println("Enter command:");
                System.out.println("  U - Update inventory (send JSON)");
                System.out.println("  R - Retrieve current inventory as JSON");
                System.out.println("  X - Exit");
                System.out.print("> ");

                String command = scanner.nextLine().trim();

                if (command.equalsIgnoreCase("U")) {
                    out.println("U");
                    System.out.println("Enter JSON array of new products:");
                    String jsonPayload = scanner.nextLine();
                    out.println(jsonPayload);
                    String response = in.readLine();
                    System.out.println("Server: " + response);
                } else if (command.equalsIgnoreCase("R")) {
                    out.println("R");
                    String inventoryJson = in.readLine();
                    System.out.println("\n📦 Current Inventory:");
                    System.out.println(inventoryJson);
                } else if (command.equalsIgnoreCase("X")) {
                    running = false;
                    System.out.println("Exiting Admin Console.");
                } else {
                    System.out.println("[Invalid command]");
                }

                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("[Admin] Connection error: " + e.getMessage());
        }
    }
}
