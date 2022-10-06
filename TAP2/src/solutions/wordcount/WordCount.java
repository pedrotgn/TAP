package solutions.wordcount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

// Download JAR from https://repo1.maven.org/maven2/com/google/guava/guava/31.1-jre/
// Add JAR dependency to IntelliJ: https://www.jetbrains.com/help/idea/working-with-module-dependencies.html
import com.google.common.util.concurrent.*;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> text = new ArrayList<>();
        Scanner sc = new Scanner(new File("pg2000.txt"));
        while (sc.hasNext()) {
            StringBuilder word = new StringBuilder();
            for (Character c : sc.next().toCharArray()) {
                if (Character.isLetterOrDigit(c))
                    word.append(c);
            }
            text.add(word.toString());
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
        AtomicLongMap<String> atomicMap = AtomicLongMap.create();
        text.stream().parallel().forEach(word -> {
            atomicMap.incrementAndGet(word);
        });
        // or also...
//        text.stream().parallel().forEach(atomicMap::incrementAndGet);

        System.out.println(atomicMap.get("Quijote"));

        // Option 3 (hard): stream
        Map<String, Long> streamWordsMap = text.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println(streamWordsMap.get("Quijote"));

    }
}
