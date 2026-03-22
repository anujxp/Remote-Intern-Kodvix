package org.example;


import java.util.concurrent.*;
        import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) throws Exception {
        // Method 1: Basic Scheduling and Timing
        explainSchedulingAndDelay();

        // Method 2: Dynamic Thread Management
        explainCachedThreadPool();

        // Method 3: Future Management
        explainScheduledFutureMethods();
    }

    /**
     * 1. Explains .schedule(), .scheduleAtFixedRate(), and .getDelay()
     */
    public static void explainSchedulingAndDelay() throws InterruptedException {
        System.out.println("--- Method 1: Scheduling Logic ---");
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // .schedule(): Runs once after a 3-second delay
        ScheduledFuture<?> oneTimeTask = scheduler.schedule(() ->
                System.out.println("One-time task executed!"), 3, TimeUnit.SECONDS);

        // .getDelay(): Monitoring the "Countdown"
        // We check how much time is left until the task above starts
        while (!oneTimeTask.isDone()) {
            long remaining = oneTimeTask.getDelay(TimeUnit.SECONDS);
            if (remaining > 0) {
                System.out.println("Task starts in: " + remaining + "s...");
            }
            Thread.sleep(1000);
        }

        // .scheduleAtFixedRate(): Runs every 2 seconds, starting now
        System.out.println("Starting periodic task every 2 seconds...");
        scheduler.scheduleAtFixedRate(() ->
                System.out.println("Heartbeat pulse..."), 0, 2, TimeUnit.SECONDS);

        // Shutting down after 5 seconds to clear the console
        Thread.sleep(5000);
        scheduler.shutdown();

        scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("[FixedDelay] Starting work...");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            System.out.println("[FixedDelay] Work finished, starting 3s gap.");
        }, 0, 3, TimeUnit.SECONDS);

        Thread.sleep(10000);
        scheduler.shutdown();
    }

    /**
     * 2. Explains the Cached Thread Pool (Elasticity)
     */
    public static void explainCachedThreadPool() {
        System.out.println("\n--- Method 2: Cached Thread Pool ---");

        // This pool has no fixed size. It grows to handle spikes.
        ExecutorService cachedPool = Executors.newCachedThreadPool();

        for (int i = 1; i <= 3; i++) {
            int taskId = i;
            cachedPool.submit(() -> {
                System.out.println("Task " + taskId + " handled by: " + Thread.currentThread().getName());
            });
        }

        // Note: Idle threads are killed after 60 seconds of inactivity.
        cachedPool.shutdown();
    }

    /**
     * 3. Explains ScheduledFuture Class Methods
     */
    public static void explainScheduledFutureMethods() throws Exception {
        System.out.println("\n--- Method 3: ScheduledFuture Management ---");
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        ScheduledFuture<String> future = scheduler.schedule(() -> {
            Thread.sleep(1000);
            return "SUCCESS";
        }, 2, TimeUnit.SECONDS);

        // .getDelay(): Check remaining wait time
        System.out.println("Initial Delay: " + future.getDelay(TimeUnit.SECONDS) + "s");

        // .isDone(): Check if task finished or was cancelled
        System.out.println("Is task finished? " + future.isDone());

        // .get(): Blocks the main thread until the result is ready
        String result = future.get();
        System.out.println("Task result retrieved: " + result);

        // .cancel(boolean): Used to stop a task before it starts or while running
        ScheduledFuture<?> cancelledTask = scheduler.schedule(() -> {}, 10, TimeUnit.SECONDS);
        cancelledTask.cancel(true);
        System.out.println("Was task cancelled? " + cancelledTask.isCancelled());

        scheduler.shutdown();
    }
}