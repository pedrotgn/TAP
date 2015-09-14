package bank;

/**
 * Created by pedro on 9/14/15.
 */
public class BonusAccount extends Account {
    public BonusAccount(int balance, Customer owner) {
        super(balance, owner);
        interest = 0.6;
    }
}
