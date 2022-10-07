package vthreads;



/*

To compile and run this in IntelliJ

https://foojay.io/today/how-to-run-project-loom-from-intellij-idea/

*/


import java.time.Duration;

public class VirtualThread {
    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            if (i%10_000 == 0) {
                System.out.println(i);
            }
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(Duration.ofMinutes(10).toMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }});
        }

        for (int i = 0; i < 1_000_000; i++) {
            if (i%10_000 == 0) {
                System.out.println(i);
            }
          //UNCOMMENT WHEN CONFIGURED ENVIRONMENT.
            /*    Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(Duration.ofMinutes(10).toMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }});*/
        }
    }
}