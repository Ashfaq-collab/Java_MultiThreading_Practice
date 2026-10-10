import java.util.ArrayList;
import java.util.List;

public class Experiment_12ThreadSafeCollections {
    public static void main(String[] args)
            throws InterruptedException {

        List<Integer> numbers = new ArrayList<>();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                numbers.add(i);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Expected size: 2000");
        System.out.println("Actual size: " + numbers.size());
    }
}
