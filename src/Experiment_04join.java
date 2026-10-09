public class Experiment_04join {
    public static void main(String[] args)
            throws InterruptedException {

        Thread worker = new Thread(() -> {
            System.out.println("Worker started");
            System.out.println("Worker finished");
        });

        worker.start();

        worker.join();

        System.out.println("Main finished");
    }
}
