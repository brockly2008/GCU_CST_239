package app;

public class Gun extends Weapon {

    // Overrides the fireWeapon method from the Weapon class
    @Override
    public void fireWeapon(int power) {
        System.out.println("In Gun.fireWeapon() with a power of " + power);
    }

    // Overrides the activate method from the Weapon class
    @Override
    public void activate(boolean enable) {
        System.out.println("In Gun.activate() with enable = " + enable);
    }

    // Overloaded method to fire the weapon with a default power level
    public void fireWeapon() {
        System.out.println("In the overloaded Gun.fireWeapon()");
        super.fireWeapon(15); // Calls the fireWeapon method in the superclass with a default power of 15
    }
}
