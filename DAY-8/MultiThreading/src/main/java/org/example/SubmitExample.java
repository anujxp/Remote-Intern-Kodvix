package org.example;

import java.util.concurrent.*;

public class SubmitExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // --- 1. submit(Runnable) ---
        // Purpose: Fire and forget logic.
        Future<?> runnableFuture = executor.submit(() -> {
            System.out.println("[Runnable] Running background logging...");
        });

        // --- 2. submit(Callable) ---
        // Purpose: Perform calculation and return a dynamic result.
        Future<Integer> callableFuture = executor.submit(() -> {
            System.out.println("[Callable] Calculating factorial or sum...");
            Thread.sleep(500); // Simulating work
            return 100 * 2;
        });

        // --- 3. submit(Runnable, T result) ---
        // Purpose: Perform logic and return a pre-defined success object/status.
        String completionStatus = "SUCCESS_FLAG";
        Future<String> runnableWithResultFuture = executor.submit(() -> {
            System.out.println("[Runnable+Result] Updating shared resource...");
        }, completionStatus);

        // --- Printing the Results ---
        System.out.println("\n--- Future Get Results ---");

        // returns null
        System.out.println("1. Runnable Result: " + runnableFuture.get());

        // returns 200
        System.out.println("2. Callable Result: " + callableFuture.get());

        // returns "SUCCESS_FLAG"
        System.out.println("3. Runnable+Result Result: " + runnableWithResultFuture.get());

        // Always shutdown the executor
        executor.shutdown();
    }
}