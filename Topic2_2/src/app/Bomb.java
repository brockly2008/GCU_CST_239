package app;

public class Bomb extends Weapon {

    // Overrides the fireWeapon method from the Weapon class
    @Override
    public void fireWeapon(int power) {
        System.out.println("In Bomb.fireWeapon() with a power of " + power);
    }

    // Overrides the activate method from the Weapon class
    @Override
    public void activate(boolean enable) {
        System.out.println("In Bomb.activate() with enable = " + enable);
    }

    // Overloaded method to fire the weapon with a default power level
    public void fireWeapon() {
        System.out.println("In the overloaded Bomb.fireWeapon()");
        super.fireWeapon(10); // Calls the fireWeapon method in the superclass with a default power of 10
    }
}
