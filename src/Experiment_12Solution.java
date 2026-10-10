import java.util.ArrayList;
import java.util.List;

public class Experiment_12Solution {

        public static void main(String[] args)
                throws InterruptedException {

            List<Integer> numbers = new ArrayList<>();
            //or Use a thread-safe collection
            //List<Integer> numbers =
            //        java.util.Collections.synchronizedList(
            //                new ArrayList<>()
            //        );
            //Then the task can simply use:
            //numbers.add(i);
            Object lock = new Object();

            Runnable task = () -> {
                for (int i = 0; i < 1000; i++) {

                    synchronized (lock) {
                        numbers.add(i);
                    }
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
