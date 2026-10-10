import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Experiment_10ExecuterService {
    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;

            executor.submit(() -> {
                String threadName =
                        Thread.currentThread().getName();

                System.out.println(
                        "Task " + taskId
                                + " executed by " + threadName
                );
            });
        }

        executor.shutdown();

        System.out.println("Main method finished submitting tasks.");
    }
}
