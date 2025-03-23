package storefront;

public class Armor extends SalableProduct {
    private int defense;

    public Armor(String name, String description, double price, int quantity, int defense) {
        super(name, description, price, quantity);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }
}
