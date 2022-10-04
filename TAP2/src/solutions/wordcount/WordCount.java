package solutions.wordcount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
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
        HashMap<String, Long> wordsMap = new HashMap<>();
        for (String word : text) {
            if (wordsMap.containsKey(word)) {
                long value = wordsMap.get(word);
                value += 1;
                wordsMap.put(word, value);
            } else {
                wordsMap.put(word, 1L);
            }
        }

        System.out.println(wordsMap.get("Quijote"));

        // Option 2: parallel stream
        ConcurrentHashMap<String, Long> concurrentWordsMap = new ConcurrentHashMap<>();
        text.stream().parallel().forEach(word -> {
            if (concurrentWordsMap.containsKey(word)) {
                long value = wordsMap.get(word);
                value += 1;
                concurrentWordsMap.put(word, value);
            } else {
                concurrentWordsMap.put(word, 1L);
            }
        });

        System.out.println(concurrentWordsMap.get("Quijote"));

        // Option 3 (hard): stream
        Map<String, Long> streamWordsMap = text.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println(streamWordsMap.get("Quijote"));

    }
}
