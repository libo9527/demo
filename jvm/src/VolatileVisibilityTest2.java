/**
 * @author bo li
 * @date 2020-06-10 10:11
 */
public class VolatileVisibilityTest2 {

    private static volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(num);
    }

    public static void increase() {
        num++;
    }
}
