public class Experiment_02 {
    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println(
                    "Running on: "
                            + Thread.currentThread().getName()
            );
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
