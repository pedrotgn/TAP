package functional;

import java.util.stream.IntStream;

/**
 * Created by pedro on 9/20/17.
 */
public class TestParallel {

    public static void main (String[] args) {

        long start = System.currentTimeMillis();
        IntStream s = IntStream.range(0, 20);
     //   System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        s.parallel().forEach(i -> {
            try {
                Thread.sleep(100);
            } catch (Exception ignore) {
            }
            System.out.print((System.currentTimeMillis() - start) + " ");
        });

    }
}
