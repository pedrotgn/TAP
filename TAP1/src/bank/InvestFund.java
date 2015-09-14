package bank;

/**
 * Created by pedro on 9/14/15.
 */
public class InvestFund extends Account{
    private double amount;

    public InvestFund(int balance, Customer owner) {
        super(balance, owner);
        interest = 0.34;
    }

    @Override
    public void withdraw(double amount) throws NoMoney{
        throw new NoMoney("InvestFund is locked");
    }

}
