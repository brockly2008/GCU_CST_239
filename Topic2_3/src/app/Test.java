package app;

public class Test {
    public static void main(String[] args) {
        // Create two Person objects with the same first and last name
        Person person1 = new Person("Justine", "Reha");
        Person person2 = new Person("Brianna", "Reha");

        // Create a third Person object using the copy constructor
        Person person3 = new Person(person1);

        // Compare person1 and person2 using the == operator
        if (person1 == person2) {
            System.out.println("These persons are identical using ==.");
        } else {
            System.out.println("These persons are not identical using ==.");
        }

        // Compare person1 and person2 using the equals() method
        if (person1.equals(person2)) {
            System.out.println("These persons are identical using equals().");
        } else {
            System.out.println("These persons are not identical using equals().");
        }

        // Compare person1 and person3 using the equals() method
        if (person1.equals(person3)) {
            System.out.println("These copied persons are identical using equals().");
        } else {
            System.out.println("These copied persons are not identical using equals().");
        }

        // Print all Person objects using toString()
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
    }
}
