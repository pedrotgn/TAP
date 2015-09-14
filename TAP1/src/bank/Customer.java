package bank;

/**
 * Created by pedro on 9/14/15.
 */
public class Customer {
    private String id;
    private String name;
    private String address;
    private String phoneNumber;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
