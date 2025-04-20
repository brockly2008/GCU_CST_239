package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import storefront2.SalableProduct;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles loading and saving inventory data to/from a JSON file.
 */
public class FileService {
    private final String filePath = "inventory.json";

    /**
     * Loads the inventory from a JSON file using Jackson.
     *
     * @return a list of SalableProduct objects (Weapon, Armor, Health)
     */
    public List<SalableProduct> loadInventory() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(filePath);
            System.out.println("Loading inventory from: " + file.getAbsolutePath());

            if (file.exists()) {
                return mapper.readValue(file, new TypeReference<List<SalableProduct>>() {});
            } else {
                System.out.println("inventory.json not found. Starting with empty inventory.");
                return new ArrayList<>();
            }
        } catch (IOException e) {
            System.err.println("Failed to load inventory: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Saves the inventory to a JSON file.
     *
     * @param inventory the list of products to save
     */
    public void saveInventory(List<SalableProduct> inventory) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), inventory);
            System.out.println("Inventory saved to " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to save inventory: " + e.getMessage());
        }
    }
}
