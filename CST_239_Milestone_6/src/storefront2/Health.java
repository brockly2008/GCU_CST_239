package storefront2;

/**
 * Health product with a healAmount attribute.
 */
public class Health extends SalableProduct {
    private int healAmount;

    public Health() {
        super();
    }

    public Health(String name, String description, double price, int quantity, int healAmount) {
        super(name, description, price, quantity);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public String toString() {
        return super.toString() + " | HEAL: " + healAmount;
    }
}
