public class Experiment_04interrupt {
    public static void main(String[] args)
            throws InterruptedException {

        Thread worker = new Thread(() -> {
            try {
                System.out.println("Worker sleeping");
                Thread.sleep(10_000);
                System.out.println("Worker woke normally");

            } catch (InterruptedException e) {
                System.out.println("Worker was interrupted");
            }
        });

        worker.start();

        Thread.sleep(500);

        worker.interrupt();

        worker.join();

        System.out.println("Main finished");
    }
}
