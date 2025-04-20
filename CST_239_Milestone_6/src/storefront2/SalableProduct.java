package storefront2;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Abstract base class for all salable products in the store.
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Weapon.class, name = "weapon"),
    @JsonSubTypes.Type(value = Armor.class, name = "armor"),
    @JsonSubTypes.Type(value = Health.class, name = "health")
})
public abstract class SalableProduct {
    protected String name;
    protected String description;
    protected double price;
    protected int quantity;

    public SalableProduct() {}

    public SalableProduct(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return String.format("%s - %s ($%.2f) Qty: %d", name, description, price, quantity);
    }
}
