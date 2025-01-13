package app;

/**
 * Represents a person with attributes such as age, name, height, and weight.
 */
public class Person {
    private int age;
    private String name;
    private float height;
    private float weight;

    /**
     * Constructs a new Person object with specified attributes.
     *
     * @param age    The age of the person.
     * @param name   The name of the person.
     * @param height The height of the person in inches.
     * @param weight The weight of the person in pounds.
     */
    public Person(int age, String name, float height, float weight) {
        this.age = age;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Gets the age of the person.
     *
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age The new age of the person.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The new name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the height of the person.
     *
     * @return The height of the person in inches.
     */
    public float getHeight() {
        return height;
    }

    /**
     * Sets the height of the person.
     *
     * @param height The new height of the person in inches.
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Gets the weight of the person.
     *
     * @return The weight of the person in pounds.
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the person.
     *
     * @param weight The new weight of the person in pounds.
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Simulates the person walking.
     */
    public void walk() {
        System.out.println("I'm walkin' here!");
    }

    /**
     * Simulates the person running for a specified distance.
     *
     * @param distance The distance the person has run, in miles.
     * @return The distance the person ran.
     */
    public float run(float distance) {
        System.out.println("I'm now running and I've ran for... " + distance + " miles.");
        return distance;
    }

    /**
     * Main method to demonstrate the functionality of the Person class.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        Person person = new Person(34, "Brock", 58.0f, 235.5f);
        System.out.println("Hello there, my name is " + person.getName() +
            ", I'm " + person.getAge() + " years of age, I'm also about " +
            person.getHeight() + " inches tall and I'm roughly " + person.getWeight() + " lbs.");
        person.walk();
        float distance = person.run(5);
        System.out.println("Distance ran: " + distance + " miles.");
    }
}
