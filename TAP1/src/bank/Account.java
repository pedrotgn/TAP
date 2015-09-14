package bank;

/**
 * Created by pedro on 9/14/15.
 */
public class Account {
    protected double balance;
    private Customer owner;

    public void setInterest(double interest) {
        this.interest = interest;
    }

    protected double interest;

    public Account(double balance, Customer owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }

    public void withdraw(double amount) throws NoMoney{
        if (amount>balance)
            throw new NoMoney("No money enough");
        else
            balance = balance - amount;
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", owner=" + owner +
                '}';
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public double getInterest(){
        return interest;
    }

    public double getComission(){
        return 1;
    }

    public void revision(){
        balance = balance + balance*getInterest()-getComission();

    }

}
