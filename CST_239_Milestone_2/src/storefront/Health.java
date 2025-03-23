package storefront;

public class Health extends SalableProduct {
    private int healing;

    public Health(String name, String description, double price, int quantity, int healing) {
        super(name, description, price, quantity);
        this.healing = healing;
    }

    public int getHealing() {
        return healing;
    }
}
