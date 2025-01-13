package car;

/**
 * Represents an engine of a car with functionality to start, stop, 
 * and check its running state.
 */
public class Engine {
    /**
     * Indicates whether the engine is currently running.
     */
    private boolean isRunning;

    /**
     * Constructs a new Engine in a stopped state.
     */
    public Engine() {
        this.isRunning = false; // By default, the engine is not running
    }

    /**
     * Starts the engine by setting its state to running.
     */
    public void start() {
        isRunning = true; // Set isRunning to true
    }

    /**
     * Stops the engine by setting its state to not running.
     */
    public void stop() {
        isRunning = false; // Set isRunning to false
    }

    /**
     * Checks whether the engine is currently running.
     *
     * @return true if the engine is running, false otherwise
     */
    public boolean isRunning() {
        return isRunning; // Return the current state of the engine
    }
}
