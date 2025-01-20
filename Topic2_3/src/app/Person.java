package app;

public class Person {
    private String firstName = "Brock";
    private String lastName = "Penrod";

    // Non-default constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Copy constructor
    public Person(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    // Override equals() method
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true; // Same object reference
        }
        if (other == null || getClass() != other.getClass()) {
            return false; // Null or different class
        }
        Person person = (Person) other;
        return this.firstName.equals(person.firstName) && this.lastName.equals(person.lastName);
    }

    // Override toString() method
    @Override
    public String toString() {
        return "My class is " + getClass().getName() + " " + this.firstName + " " + this.lastName;
    }
}
