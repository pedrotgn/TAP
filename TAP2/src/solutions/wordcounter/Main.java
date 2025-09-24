package solutions.wordcounter;

import com.google.common.util.concurrent.AtomicLongMap;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {
    /**
     * @param url the URL to fetch text from
     * @return the text content from the URL
     * @throws Exception
     */
    static String getTextFromUrl(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new Exception("HTTP error: " + response.statusCode());
        }
    }

    public static void main(String[] args) throws Exception {
        String text = getTextFromUrl("http://norvig.com/big.txt");
        // String text = getTextFromUrl("https://www.gutenberg.org/cache/epub/2000/pg2000.txt");

        // repeat text N times to increase size
        int N = 50;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(text).append(" ");
        }
        text = sb.toString();

        System.out.println("Sequential processing...");
        long start = System.nanoTime();
        String[] words = text.split("\\W+");
        System.out.println("Word count: " + words.length);
        System.out.println("Time taken (sequential): " + (System.nanoTime() - start) / 1_000_000 + " ms");


        System.out.println("Parallel processing...");
        start = System.nanoTime();
        AtomicLongMap<String> wordCounts = AtomicLongMap.create();

        ForkJoinPool.commonPool().submit(() ->
                Arrays.stream(words)
                        .parallel()
                        .filter(w -> !w.isEmpty())
                        .forEach(wordCounts::incrementAndGet)
        ).get();

        System.out.println("Word count (parallel): " + wordCounts.sum());
        System.out.println("Time taken (parallel): " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }
}
