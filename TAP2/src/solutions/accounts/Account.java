package solutions.accounts;

/**
 * Created by pedro on 9/21/15.
 */
public class Account {
    private String id;
    private String name;
    private AccType type;
    private double balance;


    public Account(String id, String name, AccType type, double balance) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public AccType getType() {

        return type;
    }

    public Account(String id, String name, String type, double balance) {
        this.id = id;
        this.name = name;
        //this.type = type;
        this.balance = balance;

        switch (type){
            case "IF":this.type = AccType.IF;break;
            case "CA":this.type = AccType.CA;break;
            case "SA":this.type = AccType.SA;break;
            case "BA":this.type = AccType.BA;
        }

    }

    public void deposit(double money){
        balance = balance + money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", type=" + type +
                '}';
    }
}
