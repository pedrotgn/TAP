package bank;

/**
 * Created by pedro on 9/14/15.
 */
public class CheckingAccount extends Account {
    public CheckingAccount(int balance, Customer owner) {
        super(balance, owner);
        interest = 0.1;

    }

    public void revision(){
        balance = balance + balance*getInterest();

    }
}
