import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Experiment_10CallableFuture {
    public static void main(String[] args) throws Exception {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            System.out.println("Calculating sum...");

            int sum = 0;

            for (int i = 1; i <= 5; i++) {
                sum += i;
            }

            return sum;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Task submitted.");

        System.out.println("Before getting result");

        Integer result = future.get();

        System.out.println("Result: " + result);

        executor.shutdown();
    }
}
