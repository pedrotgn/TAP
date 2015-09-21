package others;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by pedro on 9/21/15.
 */
public class Tokens {

    public static void main(String[] args) throws IOException {



        FileReader fis = new FileReader("accounts.txt");
        BufferedReader dis = new BufferedReader(fis);
        String line;

        while ((line = dis.readLine()) != null) {
            System.out.println("Account: ------------------------------");
            StringTokenizer tokens = new StringTokenizer(line, ",");
            while (tokens.hasMoreTokens()) {
                System.out.println(tokens.nextToken());
            }
        }

        dis.close();

    }
}
