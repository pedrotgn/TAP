package solutions.bank;

/**
 * Created by pedro on 9/14/15.
 */
public class NoMoney extends Exception {
    public NoMoney(String message) {
        super(message);
    }
    public NoMoney(){super("No money enough");}
}
