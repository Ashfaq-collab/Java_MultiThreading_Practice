public class Experiment_06withoutVolatile {
    static boolean running = true;

    public static void main(String[] args)
            throws InterruptedException {

        Thread worker = new Thread(() -> {
            System.out.println("Worker started");

            while (running) {
                // Keep checking the flag
            }

            System.out.println("Worker stopped");
        });

        worker.start();

        Thread.sleep(1000);

        System.out.println("Main thread setting running = false");
        running = false;

        worker.join(2000);

        System.out.println("Worker state: " + worker.getState());
    }
}
