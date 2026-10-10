import java.util.concurrent.CountDownLatch;

public class Experiment_14CountownLatch {
    public static void main(String[] args)
            throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 1; i <= 3; i++) {
            int workerId = i;

            new Thread(() -> {
                try {
                    System.out.println(
                            "Worker " + workerId + " started."
                    );

                    Thread.sleep(workerId * 1000L);

                    System.out.println(
                            "Worker " + workerId + " finished."
                    );

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();

                } finally {
                    latch.countDown();
                }
            }).start();
        }

        System.out.println("Main thread is waiting...");

        //latch.await();

        System.out.println("All workers finished!");
    }
    //If you initialize it with 2, the main thread can continue after just two calls to countDown(),
    //even if the third worker is still working.
}
