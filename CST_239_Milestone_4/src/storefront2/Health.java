// --- Health.java ---
package storefront2;

/**
 * Health item class used to heal the player.
 */
public class Health extends SalableProduct {
    private int healAmount;
    
    public Health(String name, String description, double price, int quantity) {
            super(name, description, price, quantity);
        }
    

    public Health(String name, String description, double price, int quantity, int healAmount) {
        super(name, description, price, quantity);
        this.healAmount = healAmount;
    }

    public int getHealAmount() { return healAmount; }
}