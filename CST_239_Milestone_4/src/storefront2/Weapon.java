// --- Weapon.java ---
package storefront2;

/**
 * Weapon class representing a type of SalableProduct with damage attribute.
 * Implements Comparable for alphabetical sorting.
 */
public class Weapon extends SalableProduct implements Comparable<Weapon> {
    private int damage;

    
    public Weapon(String name, String description, double price, int quantity) {
        super(name, description, price, quantity);
        this.damage = 0; // or set a default if needed
    }

    
    public Weapon(String name, String description, double price, int quantity, int damage) {
        super(name, description, price, quantity);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public int compareTo(Weapon other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}
