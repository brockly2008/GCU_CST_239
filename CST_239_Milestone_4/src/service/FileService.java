package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import storefront2.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private final ObjectMapper mapper;

    public FileService() {
        this.mapper = new ObjectMapper();
    }

    public List<SalableProduct> readInventoryFromFile(String filePath) throws IOException {
        List<SalableProduct> productList = new ArrayList<>();
        File file = new File(filePath);
        JsonNode root = mapper.readTree(file);

        for (JsonNode node : root) {
            String type = node.get("type").asText();
            String name = node.get("name").asText();
            String description = node.get("description").asText();
            double price = node.get("price").asDouble();
            int quantity = node.get("quantity").asInt();

            SalableProduct product = null;

            switch (type) {
                case "Weapon":
                    product = new Weapon(name, description, price, quantity);
                    break;
                case "Armor":
                    product = new Armor(name, description, price, quantity);
                    break;
                case "Health":
                    product = new Health(name, description, price, quantity);
                    break;
            }

            if (product != null) {
                productList.add(product);
            }
        }

        return productList;
    }
}
