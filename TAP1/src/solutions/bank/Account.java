package solutions.bank;

import java.io.Serializable;


/**
 * Created by pedro on 9/14/15.
 */
public class Account implements Serializable {
    protected double balance;
    private Customer owner;
    protected double interest;

    public Account(double balance, Customer owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public Customer getOwner() {
        return owner;
    }
    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance = balance + amount;
    }
    public void withdraw(double amount) throws NoMoney {
        if (amount>balance)
            throw new NoMoney();
        else
            balance = balance - amount;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    public double getInterest(){
        return interest;
    }
    public double getCommission(){
        return 10;
    }
    public void revision(){
        balance = balance + balance * getInterest() - getCommission();
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", owner=" + owner +
                '}';
    }
}
