package app;

import java.util.Random;

// Class representing the game logic for a battle between Superman and Batman
public class Game {
    public static void main(String[] args) {
        // Generate random health values between 1 and 1000 for each superhero
        Random rand = new Random();
        int health1 = rand.nextInt(1000) + 1; // Random health for Superman
        int health2 = rand.nextInt(1000) + 1; // Random health for Batman

        // Inform the user that superheroes are being created
        System.out.println("Creating our Super Heroes......");
        // Create Superman with the generated health
        Superman superman = new Superman(health1);
        // Create Batman with the generated health
        Batman batman = new Batman(health2);
        System.out.println("Super Heroes created!"); // Notify that superheroes are ready

        // Start the game and keep it running until one superhero is dead
        System.out.println("Running our game......");
        while (!superman.isDead() && !batman.isDead()) { // Check if both superheroes are alive
            // Superman attacks Batman
            superman.attack(batman);
            if (!batman.isDead()) { // If Batman is still alive, he attacks Superman
                batman.attack(superman);
            }
        }

        // Determine and print the winner based on who is still alive
        if (superman.isDead()) {
            System.out.println("Batman defeated Superman!"); // Superman is dead, Batman wins
        }
        if (batman.isDead()) {
            System.out.println("Superman defeated Batman!"); // Batman is dead, Superman wins
        }
    }
}
