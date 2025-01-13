package car;

/**
 * Represents a car tire with functionality to inflate the tire and check its PSI.
 */
public class Tire {
    /**
     * The current PSI (pounds per square inch) of the tire.
     */
    private int psi;

    /**
     * Constructs a new Tire with the specified initial PSI.
     *
     * @param psi the initial PSI of the tire
     */
    public Tire(int psi) {
        this.psi = psi; // Set the initial PSI of the tire
    }

    /**
     * Inflates the tire by a specified amount of PSI.
     *
     * @param psi the amount of PSI to add to the current tire pressure
     */
    public void inflate(int psi) {
        this.psi += psi; // Add the specified PSI to the current PSI
    }

    /**
     * Checks if the tire's PSI is within the acceptable range of 30 to 35.
     *
     * @return true if the PSI is between 30 and 35 (inclusive), false otherwise
     */
    public boolean isGoodPsi() {
        return psi >= 30 && psi <= 35; // Returns true if PSI is within the acceptable range
    }
}
