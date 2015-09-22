package solutions.accounts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * Created by pedro on 9/21/15.
 */
public class Tokens {

    public static void main(String[] args) throws IOException {



        FileReader fis = new FileReader("accounts.txt");
        BufferedReader dis = new BufferedReader(fis);
        String line;

        List<Account> list = new LinkedList<>();


        while ((line = dis.readLine()) != null) {
           StringTokenizer tokens = new StringTokenizer(line, ",");
            while (tokens.hasMoreTokens()) {
                Account c = new Account(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), new Double(tokens.nextToken()).doubleValue());
                list.add(c);
            }
        }

        dis.close();

        for (Account acc:list)
            System.out.println(acc);

        System.out.println("Exercise 1: MAP");
        list.stream().map((Account c) -> {
            c.deposit(100);
            return c;
        });
        list.forEach(e -> System.out.println(e));

        System.out.println("Exercise 2: FILTER");
        Stream<Account> result = list.stream().filter(acc -> acc.getType().equals(AccType.IF));
        result.forEach(e -> System.out.println(e));

        System.out.println("Exercise 2: FILTER");

        System.out.println("Exercise 2: MAX");
        Stream<Account> result1 = list.stream().filter(acc -> acc.getType().equals(AccType.IF));
        Account resultacc = result1.max((e1,e2)->Double.compare(e1.getBalance(),e2.getBalance())).get();
        System.out.println(resultacc);


    }
}
