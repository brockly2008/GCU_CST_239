package storefront2;

/**
 * Armor product with a defense attribute.
 */
public class Armor extends SalableProduct {
    private int defense;

    public Armor() {
        super();
    }

    public Armor(String name, String description, double price, int quantity, int defense) {
        super(name, description, price, quantity);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return super.toString() + " | DEF: " + defense;
    }
}
