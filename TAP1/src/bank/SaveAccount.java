package bank;

/**
 * Created by pedro on 9/14/15.
 */
public class SaveAccount extends Account{
    public SaveAccount(int balance, Customer owner) {
        super(balance, owner);
        interest = 0.2;
    }
}
