package app;

import java.util.Random;

public class SuperHero {
		
    private String name; // The name of the superhero
    private int health; // The current health points of the superhero
    private boolean isDead; // Indicates whether the superhero is alive or dead

    // Constructor
    public SuperHero(String name, int health) {
        this.name = name; // Initialize the superhero's name
        this.health = health; // Initialize the superhero's health points
        this.isDead = false; // Superheroes start alive
    }

    // Attack method
    public void attack(SuperHero opponent) {
        Random rand = new Random();
        int damage = rand.nextInt(10) + 1; // Random damage between 1 and 10
        opponent.determineHealth(damage); // Apply damage to the opponent
        System.out.printf("%s dealt %d damage to %s. %s's health is now %d%n",
                this.name, damage, opponent.name, opponent.name, opponent.health);
    }

    // Check if dead
    public boolean isDead() {
        return this.isDead; // Return the dead/alive status of the superhero
    }

    // Determine health
    private void determineHealth(int damage) {
        if (this.health - damage <= 0) {
            this.health = 0; // Health cannot drop below 0
            this.isDead = true; // Mark the superhero as dead
        } else {
            this.health -= damage; // Reduce health by the damage amount
        }
    }
}