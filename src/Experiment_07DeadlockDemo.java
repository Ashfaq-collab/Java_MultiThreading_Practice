public class Experiment_07DeadlockDemo {
    static final Object lockA = new Object();
    static final Object lockB = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread 1 acquired Lock A");

                sleepBriefly();

                System.out.println("Thread 1 waiting for Lock B");

                synchronized (lockB) {
                    System.out.println("Thread 1 acquired Lock B");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread 2 acquired Lock A");

                sleepBriefly();

                System.out.println("Thread 2 waiting for Lock B");

                synchronized (lockB) {
                    System.out.println("Thread 2 acquired Lock B");
                }
            }
        });

        t1.start();
        t2.start();
    }
    //give the exact resource access order to Thread2

    static void sleepBriefly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
