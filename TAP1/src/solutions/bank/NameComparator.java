package solutions.bank;

import java.util.Comparator;

public class NameComparator implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        String name1 = o1.getOwner().getName();
        String name2 = o2.getOwner().getName();
        return name1.compareTo(name2);
    }
}
