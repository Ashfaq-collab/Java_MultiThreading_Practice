public class Experiment_05Syncronized {
    static int counter = 0;

    static synchronized void incrementCounter() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                incrementCounter();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final counter: " + counter);
    }
}
