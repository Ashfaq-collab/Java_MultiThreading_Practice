import java.util.concurrent.*;

public class Experiment_11CancellingTaskandTimouts {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Working... " + i);
                    Thread.sleep(1000);
                }

                return "Task completed";
            } catch (InterruptedException e) {
                System.out.println("Task was interrupted.");
                Thread.currentThread().interrupt();
                return "Task interrupted";
            }
        });

        try {
            String result = future.get(5, TimeUnit.SECONDS);
            System.out.println("Result: " + result);

        } catch (TimeoutException e) {
            System.out.println("Timed out! Cancelling task.");
            future.cancel(true);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");

        } catch (ExecutionException e) {
            System.out.println("Task failed: " + e.getCause());
        }

        System.out.println("Is done? " + future.isDone());
        System.out.println("Is cancelled? " + future.isCancelled());

        executor.shutdown();
    }
}
