package app;

public class Game {
    public static void main(String[] args) {
        // Create instances of Bomb and Gun
        Bomb weapon1 = new Bomb();
        Gun weapon2 = new Gun();

        // Call the activate method for both weapons
        weapon1.activate(true);
        weapon2.activate(true);

        // Call the fireWeapon method with specific power levels
        weapon1.fireWeapon(10);
        weapon2.fireWeapon(5);

        // Call the overloaded fireWeapon method for both weapons
        weapon1.fireWeapon();
        weapon2.fireWeapon();
    }
}
