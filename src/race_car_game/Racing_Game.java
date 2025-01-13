package race_car_game;

import racecars.RaceCar;

/**
 * Represents a simple racing game where a RaceCar can be started, 
 * checked for tire pressure, driven at a certain speed, stopped, and restarted.
 */
public class Racing_Game {

    /**
     * The main method to run the Racing Game.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Create a new RaceCar instance
        RaceCar myCar = new RaceCar();

        // Start the car
        myCar.start();

        // Check if all tires have acceptable PSI levels
        if (myCar.checkTires()) {
            System.out.println("All tires are at good PSI.");
        } else {
            System.out.println("Tires need inflation.");
        }

        // Run the car at 60 mph
        myCar.run(60);

        // Stop the car
        myCar.stop();

        // Restart the car
        myCar.restart();
    }
}
