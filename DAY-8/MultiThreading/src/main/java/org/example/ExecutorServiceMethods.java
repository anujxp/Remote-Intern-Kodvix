package org.example;

import java.util.concurrent.ExecutionException;

 import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceMethods {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 1. Initialization: Creating a pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("--- 1. Basic Submission Methods ---");

        // execute(Runnable): Fire and forget, returns void
        executor.execute(() -> System.out.println("[execute] Running simple task"));

        // submit(Callable): Returns a Future with a result
        Future<String> future = executor.submit(() -> {
            Thread.sleep(500);
            return "[submit] Task Result";
        });
        System.out.println("Future result: " + future.get());

        System.out.println("\n--- 2. Bulk Execution Methods ---");

        // Preparing a list of tasks
        List<Callable<String>> taskList = Arrays.asList(
                () -> { Thread.sleep(1000); return "Task A Done"; },
                () -> { Thread.sleep(500);  return "Task B Done"; },
                () -> { Thread.sleep(800);  return "Task C Done"; }
        );

        // invokeAny(): Returns the result of the FASTEST successful task and cancels others
        String fastest = executor.invokeAny(taskList);
        System.out.println("invokeAny result (Fastest): " + fastest);

        // invokeAll(): Blocks until ALL tasks are done and returns a list of Futures
        System.out.println("invokeAll: Waiting for all tasks...");
        List<Future<String>> futures = executor.invokeAll(taskList);
        for (Future<String> f : futures) {
            System.out.println("Result: " + f.get());
        }



        System.out.println("\n--- 3. Lifecycle Management ---");

        // isShutdown(): Checks if shutdown() has been called
        System.out.println("Is shutdown? " + executor.isShutdown());

        // shutdown(): Initiates an orderly shutdown (finishes current tasks)
        executor.shutdown();
        System.out.println("Shutdown initiated...");

        // awaitTermination(): Blocks the main thread for a specific time to wait for exit
        if (executor.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println("All tasks finished within timeout.");
        } else {
            // shutdownNow(): Forcefully kills all running tasks immediately
            System.out.println("Timeout reached! Forcing shutdown...");
            executor.shutdownNow();
        }

        // isTerminated(): Returns true only if all tasks are finished AND executor is closed
        System.out.println("Is terminated? " + executor.isTerminated());
    }
}
