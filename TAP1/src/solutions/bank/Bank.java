package solutions.bank;

import java.util.*;
import java.io.*;

/**
 * Created by pedro on 9/14/15.
 */
public class Bank implements Serializable, Iterable<Account>{
    private String name;
    private HashMap<String, List<Account>> accounts;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.accounts = new HashMap<>();
        this.customers = new LinkedList<>();
    }

    public void addAccount(Account newAccount){
        String id = newAccount.getOwner().getId();
        List<Account> accountsList = accounts.getOrDefault(id, new LinkedList<>());
        accountsList.add(newAccount);
        accounts.put(id, accountsList);
    }
    public void removeAccount(Account account){
        String id = account.getOwner().getId();
        List<Account> accountsList = accounts.get(id);
        accountsList.remove(account);

        if (accountsList.isEmpty())
            accounts.remove(id);
    }
    public HashMap<String, List<Account>> getAccounts(){
        return accounts;
    }
    public List<Account> getAccountsList(){
        List<Account> accountsList = new ArrayList<>();
        for (List<Account> a: accounts.values())
            accountsList.addAll(a);
        return accountsList;
    }
    public List<Account> getAccountsByOwnerId(String id){return accounts.get(id);}

    public void addCustomer(Customer newCustomer){
        customers.add(newCustomer);
    }
    public void removeCustomer(Customer oldCustomer){
        customers.remove(oldCustomer);
    }
    public List<Customer> getCustomers(){
        return customers;
    }

    public void revision(){
        for (Account acc:getAccountsList())
            acc.revision();
    }

    public void lottery(){
        Random rand = new Random();
        List<Account> accountsList = getAccountsList();
        int accountIdx = rand.nextInt(accountsList.size());
        Account a = accountsList.get(accountIdx);
        a.deposit(300);
    }

    public void storage(String filepath){
        try {
            FileOutputStream f = new FileOutputStream(filepath);
            ObjectOutputStream fos = new ObjectOutputStream(f);
            fos.writeObject(this);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
    public void recovery(String filepath){
        Bank b = Bank.from_file(filepath);
        this.name = b.name;
        this.accounts = b.accounts;
        this.customers = b.customers;
    }
    public static Bank from_file(String filepath){
        Bank b = null;

        try {
            ObjectInputStream fis = new ObjectInputStream(new FileInputStream(filepath));
            b = (Bank) fis.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        }

        return b;
    }

    public void showAccounts(){
        for (Account a:getAccountsList())
            System.out.println(a);
    }
    public void showAccountsSorted(boolean byNameNotByBalance){
        List<Account> sortedAccounts = getAccountsList();
        Comparator<Account> comp = byNameNotByBalance? new NameComparator():new BalanceComparator();
        sortedAccounts.sort(comp);

        for (Account a:sortedAccounts)
            System.out.println(a);
    }

    @Override
    public Iterator<Account> iterator() {
        return getAccountsList().iterator();
    }
}
