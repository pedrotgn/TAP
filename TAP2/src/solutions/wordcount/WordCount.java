package solutions.wordcount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> text = new ArrayList<>();
        Scanner sc = new Scanner(new File("pg2000.txt"));
        while (sc.hasNext()) {
            String word = "";
            for (Character c : sc.next().toCharArray()) {
                if (Character.isLetterOrDigit(c))
                    word += c;
            }
            text.add(word);
        }

        // Option 1: for + hashmap
        HashMap<String, Long> words = new HashMap<>();
        for (String word : text) {
            if (words.containsKey(word)) {
                long value = words.get(word);
                value += 1;
                words.put(word, value);
            } else {
                words.put(word, 1L);
            }
        }

        System.out.println(words.get("Quijote"));

        // Option 2: stream
        Map<String, Long> res = text.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println(res.get("Quijote"));

    }
}
