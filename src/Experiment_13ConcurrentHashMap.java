import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Experiment_13ConcurrentHashMap {
    public static void main(String[] args)
            throws InterruptedException {

        Map<Integer, String> students =
                new ConcurrentHashMap<>();

        Runnable task = () -> {
            for (int i = 1; i <= 1000; i++) {
                students.put(i, "Student " + i);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Expected size: 1000");
        System.out.println("Actual size: " + students.size());
        System.out.println("Student 10: " + students.get(10));
    }
}
