import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.example.ManualThreads.calculateFactorial;

public class ExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> {
                long result = calculateFactorial(finalI);
                System.out.println(Thread.currentThread().getName() + " calculated Factorial of " + finalI + ": " + result);
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("time taken for executino is" + ":" +(System.currentTimeMillis() - startTime));
    }
}
