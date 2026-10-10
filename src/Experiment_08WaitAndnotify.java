public class Experiment_08WaitAndnotify {

    static final Object lock = new Object();
    static boolean ready = false;

    public static void main(String[] args)
            throws InterruptedException {

        Thread worker = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Worker: waiting for ready");

                while (!ready) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                System.out.println("Worker: ready is true!");
            }
        });

        worker.start();

        Thread.sleep(1000);

        synchronized (lock) {
            System.out.println("Main: setting ready to true");
            ready = true;

            lock.notify();
        }

        worker.join();

        System.out.println("Main: worker finished");
    }
}
