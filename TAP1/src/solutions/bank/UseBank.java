package solutions.bank;

import java.util.List;

/**
 * Created by pedro on 9/14/15.
 */
public class UseBank {
    public static void main(String[] args) {
        Customer c1 = new Customer("1","pedro");
        Customer c2 = new Customer("2","pep");
        Customer c3 = new Customer("3","pau");

        Account a1 = new CheckingAccount(90,c1);
        Account a2 = new SaveAccount(100,c2);
        Account a3 = new InvestFund(10,c3);
        Account a4 = new BonusAccount(10,c3);

        Bank b1 = new Bank("TAP");
        b1.addAccount(a1);
        b1.addAccount(a2);
        b1.addAccount(a3);
        b1.addAccount(a4);

        b1.addCustomer(c1);
        b1.addCustomer(c2);
        b1.addCustomer(c3);

        b1.showAccounts();

        a1.deposit(10);

        try {
            a3.withdraw(1);
        }catch(NoMoney e1){
            System.out.println(e1.getMessage());
        }

        try {
            a4.withdraw(100);
        }catch(NoMoney e1){
            System.out.println(e1.getMessage());
        }

        System.out.println("Before revision:");
        b1.showAccounts();

        b1.revision();
        b1.lottery();
        System.out.println("After revision and lottery:");
        b1.showAccounts();

        System.out.println("Storage and recovery from file:");
        String filepath = "bank.ser";
        b1.storage(filepath);
        b1.recovery(filepath);
        b1.showAccounts();

        System.out.println("Account retrieval by id:");
        List<Account> retrievedAccounts = b1.getAccountsByOwnerId("3");
        for (Account a:retrievedAccounts)
            System.out.println(a);

        System.out.println("Accounts sorted by owner name:");
        b1.showAccountsSorted(true);

        System.out.println("Accounts sorted by balance:");
        b1.showAccountsSorted(false);
    }
}
