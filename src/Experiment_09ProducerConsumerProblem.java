public class Experiment_09ProducerConsumerProblem {

    static class Buffer {
        private Integer item = null;

        public synchronized void produce(int value)
                throws InterruptedException {

            while (item != null) {
                wait();
            }

            item = value;
            System.out.println("Produced: " + value);

            notifyAll();
        }

        public synchronized int consume()
                throws InterruptedException {

            while (item == null) {
                wait();
            }

            int value = item;
            item = null;

            System.out.println("Consumed: " + value);

            notifyAll();
            return value;
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("All items processed.");
    }
}
