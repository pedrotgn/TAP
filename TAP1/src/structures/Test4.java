package structures;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Pedro Garcia
 */
public class Test4 {

    public static void main(String[] args) {
        Map<String, Client> dict = new HashMap<>();
        Client p1 = new Client("homer", 40);
        Client p2 = new Client("marge", 40);
        Client p3 = new Client("bart", 12);
        Client p4 = new Client("lisa", 10);

        dict.put("dni1", p1);
        dict.put("dni2", p2);
        dict.put("dni3", p3);
        dict.put("dni4", p4);

        Client p = dict.get("dni2");
        System.out.println(p.getName());

        Set<String> keys = dict.keySet();
        Client x;
        for (String key : keys) {
            x = dict.get(key);
            System.out.println(x.getName());
        }

        System.out.println("-------------------------");

        Collection<Client> clients = dict.values();
        for (Client per : clients) {
            System.out.println(per.getName());
        }

    }
}
