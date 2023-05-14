public class Customer {

    private final String firstName;
    private final String lastName;
    private final String city;
    private final int birthYear;

    public Customer(String firstName, String lastName, String city, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
