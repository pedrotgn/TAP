package vthreads;


import java.time.Duration;

public class PlatformThread {
    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            if (i%10_000 == 0) {
                System.out.println(i);
            }
            new Thread(() -> {
                try {
                    Thread.sleep(Duration.ofMinutes(10).toMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }}).start();
        }
    }
}