public class Experiment_03A {
    public static void main(String[] args)
            throws InterruptedException {

        Thread t = new Thread(() -> {
            System.out.println("Task is running");
        });

        System.out.println("Before start: " + t.getState());

        t.start();

        t.join();

        System.out.println("After completion: " + t.getState());
    }
}
