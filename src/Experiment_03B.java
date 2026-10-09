public class Experiment_03B {

        public static void main(String[] args)
                throws InterruptedException {

            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            t.start();

            Thread.sleep(200);

            System.out.println(t.getState());

            t.join();
        }
}
