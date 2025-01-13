package racecars;

import car.Engine;
import car.Tire;

/**
 * Represents a race car with an engine, tires, and speed control functionality.
 */
public class RaceCar {
    /**
     * The engine of the race car.
     */
    private Engine engine;

    /**
     * An array of 4 tires for the race car.
     */
    private Tire[] tires;

    /**
     * The current speed of the race car in miles per hour.
     */
    private int speed;

    /**
     * Constructs a new RaceCar with a default engine and tires set to 32 PSI.
     */
    public RaceCar() {
        this.engine = new Engine(); // Create a new Engine instance
        this.tires = new Tire[4]; // Create an array for 4 tires
        for (int i = 0; i < tires.length; i++) {
            tires[i] = new Tire(32); // Initialize each tire with a default PSI of 32
        }
        this.speed = 0; // Set initial speed to 0
    }

    /**
     * Starts the race car. Checks if all tires have acceptable PSI before starting.
     */
    public void start() {
        if (checkTires()) { // Check if all tires have good PSI
            engine.start(); // Start the engine
            System.out.println("RaceCar has started.");
        } else {
            System.out.println("Cannot start RaceCar. Check tires.");
        }
    }

    /**
     * Runs the race car at a specified speed.
     *
     * @param mph the speed in miles per hour to run the race car
     */
    public void run(int mph) {
        if (engine.isRunning()) { // Check if the engine is running
            if (mph > 0) { // Ensure the speed is greater than 0
                speed = mph; // Set the speed
                System.out.println("RaceCar is running at " + speed + " mph.");
            } else {
                System.out.println("Speed must be greater than 0 to run the RaceCar.");
            }
        } else {
            System.out.println("Engine is not running. Cannot run the RaceCar.");
        }
    }

    /**
     * Stops the race car. Resets the speed to 0 and turns off the engine.
     */
    public void stop() {
        if (engine.isRunning() && speed > 0) { // Check if the car is moving and the engine is running
            speed = 0; // Reset the speed to 0
            engine.stop(); // Stop the engine
            System.out.println("RaceCar has stopped.");
        } else if (!engine.isRunning()) { // If the engine is already off
            System.out.println("RaceCar is already stopped.");
        } else { // If the car isn't moving
            System.out.println("RaceCar is not running, no need to stop.");
        }
    }

    /**
     * Restarts the race car. Stops and then starts the car again if it is already running.
     */
    public void restart() {
        if (engine.isRunning()) { // If the engine is already running
            stop(); // Stop the car
            start(); // Start it again
            System.out.println("RaceCar has restarted.");
        } else { // If the engine is off
            System.out.println("RaceCar is not running. Starting the RaceCar instead.");
            start(); // Start the car
        }
    }

    /**
     * Checks if all tires have acceptable PSI levels.
     *
     * @return true if all tires are within the acceptable PSI range, false otherwise
     */
    public boolean checkTires() {
        for (Tire tire : tires) { // Iterate through each tire
            if (!tire.isGoodPsi()) { // Check if the PSI is not within the acceptable range
                return false; // Return false if any tire is not good
            }
        }
        return true; // All tires are good
    }

    /**
     * Inflates all tires by the specified PSI.
     *
     * @param psi the amount of PSI to add to each tire
     */
    public void inflateTires(int psi) {
        for (Tire tire : tires) { // Iterate through each tire
            tire.inflate(psi); // Inflate the tire by the specified PSI
        }
    }
}
