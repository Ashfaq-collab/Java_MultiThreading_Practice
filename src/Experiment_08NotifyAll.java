public class Experiment_08NotifyAll {
    static final Object lock = new Object();
    static boolean ready = false;

    public static void main(String[] args)
            throws InterruptedException {

        Runnable task = () -> {
            synchronized (lock) {
                System.out.println(
                        Thread.currentThread().getName() + " waiting"
                );

                while (!ready) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                System.out.println(
                        Thread.currentThread().getName() + " proceeding"
                );
            }
        };

        Thread t1 = new Thread(task, "Worker-1");
        Thread t2 = new Thread(task, "Worker-2");
        Thread t3 = new Thread(task, "Worker-3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000);

        synchronized (lock) {
            ready = true;
            System.out.println("Main: notifying all workers");
            lock.notifyAll();
        }

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Main: all workers finished");
    }
}
