package solutions.bank;

import java.io.Serializable;

/**
 * Created by pedro on 9/14/15.
 * Represents a bank customer, who has one or more Accounts.
 * Uniquely identified by the id attribute.
 */
public class Customer implements Serializable {
    private String id;
    private String name;

    /**
     * Constructor defining the id and name attributes
     * @param id Unique identifier of the customer
     * @param name Name (including surname/s) of the customer
     */
    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter for the id attribute
     * @return Unique identifier of the customer
     */
    public String getId(){
        return id;
    }

    /**
     * Getter for the name attribute
     * @return Name (including surname/s) of the customer
     */
    public String getName(){
        return name;
    }

    /**
     * @return String containing the name and id of the customer
     */
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
