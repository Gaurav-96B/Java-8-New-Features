import java.util.List;
public final class Student {

    private final int id;
    private final List<String> phoneNumbers;
    private final Address address;

    public Student(int id, List<String> phoneNumbers, Address address) {
        this.id = id;

        // Defensive copy for list
        this.phoneNumbers = new ArrayList<>(phoneNumbers);

        // Defensive copy for mutable Address
        this.address = new Address(
                address.getCity(),
                address.getState()
        );
    }

    public int getId() {
        return id;
    }

    public List<String> getPhoneNumbers() {
        return new ArrayList<>(phoneNumbers);
    }

    public Address getAddress() {
        // Return copy, not original internal reference
        return new Address(
                address.getCity(),
                address.getState()
        );
    }
}
