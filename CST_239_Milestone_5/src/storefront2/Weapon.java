package storefront2;

import java.util.Comparator;

/**
 * Weapon class extending SalableProduct and implementing Comparable.
 */
public class Weapon extends SalableProduct implements Comparable<Weapon> {
    private int damage;

    public Weapon(String name, String description, double price, int quantity) {
        super(name, description, price, quantity);
        this.damage = (int)(Math.random() * 100); // Or make this passed-in later
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public int compareTo(Weapon other) {
        return this.name.compareToIgnoreCase(other.name); // Default sort by name
    }

    public static final Comparator<Weapon> BY_PRICE_ASC =
        Comparator.comparingDouble(Weapon::getPrice);

    public static final Comparator<Weapon> BY_PRICE_DESC =
        Comparator.comparingDouble(Weapon::getPrice).reversed();

    @Override
    public String toString() {
        return super.toString() + " | DMG: " + damage;
    }
}
