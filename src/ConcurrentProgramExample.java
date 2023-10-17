import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentProgramExample {

    // Define a simple task (simulating a worker)
    static class Worker implements Runnable {
        private final int workerId;

        Worker(int id) {
            this.workerId = id;
        }

        @Override
        public void run() {
            System.out.println("Worker " + workerId + " started.");
            try {
                // Simulating some work with Thread.sleep
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
            System.out.println("Worker " + workerId + " finished.");
        }
    }

    public static void main(String[] args) {
        // Create a fixed thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit 10 tasks to the executor
        for (int i = 1; i <= 10; i++) {
            executor.submit(new Worker(i));
        }

        // Shutdown the executor (it cannot accept new tasks, but will finish existing ones)
        executor.shutdown();

        // Wait for all tasks to finish
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                // Optional: Terminate all waiting threads after 60 seconds if they haven't finished
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt(); // Restore interrupted status
        }

        System.out.println("All tasks completed.");
    }
}
