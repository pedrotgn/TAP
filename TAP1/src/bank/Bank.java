package bank;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pedro on 9/14/15.
 */
public class Bank {
    private String name;
    private List<Account> accounts = new LinkedList<Account>();
    private List<Customer> customers = new LinkedList<Customer>();

    public Bank(String name) {
        this.name = name;
    }

    public void addAccount(Account newAccount){
        accounts.add(newAccount);
    }
    public void removeAccount(Account oldAccount){
        accounts.remove(oldAccount);
    }
    public List<Account> getAccounts(){
        return accounts;
    }
    public void addCustomer(Customer newCustomer){
        customers.add(newCustomer);
    }
    public void removeCustomer(Customer oldCustomer){
        customers.remove(oldCustomer);
    }
    public List<Customer> getCustomers(){
        return customers;
    }

    public void showAccounts(){
        for (Account a:accounts)
            System.out.println(a);
    }

    public void revision(){
        for (Account acc:accounts)
            acc.revision();
    }


}
