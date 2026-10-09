public class Main {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            System.out.println(
                    "Running on: " +
                            Thread.currentThread().getName()
            );
        });

        System.out.println("Before run()");
        t.run();

        System.out.println("Before start()");
        t.start();
    }
    //observe the difference
//    Thread t = new Thread(() -> {
//        for (int i = 1; i <= 5; i++) {
//            System.out.println(
//                    Thread.currentThread().getName()
//                            + " : " + i
//            );
//        }
//    });
//
//        t.start();
//
//        for (int i = 1; i <= 5; i++) {
//        System.out.println(
//                Thread.currentThread().getName()
//                        + " : " + i
//        );
//    }
}
