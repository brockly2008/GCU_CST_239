// --- Armor.java ---
package storefront2;

/**
 * Armor class representing a defensive item.
 */
public class Armor extends SalableProduct {
    private int defense;

    
    public Armor(String name, String description, double price, int quantity) {
        super(name, description, price, quantity);
        this.defense = 0; // or a default value if needed
    }

    
    public Armor(String name, String description, double price, int quantity, int defense) {
        super(name, description, price, quantity);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }
}
