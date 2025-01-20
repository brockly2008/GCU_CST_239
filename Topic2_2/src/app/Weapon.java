package app;

public abstract class Weapon {

    // Simulates firing the weapon with a given power level
    public void fireWeapon(int power) {
        System.out.println("In Weapon.fireWeapon() with a power of " + power);
    }

    // Abstract method for activating or deactivating the weapon
    public abstract void activate(boolean enable);
}
