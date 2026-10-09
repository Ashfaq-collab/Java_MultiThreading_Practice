public class Experiment_04sleep {
    public static void main(String[] args) {

        Thread worker = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Worker: " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        worker.start();

        System.out.println("Main continues");
    }
}
