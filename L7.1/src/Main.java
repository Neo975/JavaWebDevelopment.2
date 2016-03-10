/**
 * Created by Mike on 10.03.2016.
 */
public class Main {
    private static final int THREADS_NUMBER = 10_000;

    public static void main(String[] args) {
        for (int i = 0; i < THREADS_NUMBER; i++) {
            Thread thread = new SerialSequenceExample(i);
            thread.start();
        }
    }

    private static class SerialSequenceExample extends Thread {
        private static int currentMax = 0;
        private final int mainId;
        private static final Object waitObject = new Object();

        public SerialSequenceExample(int id) {
            this.mainId = id;
        }

        @Override
        public void run() {
            try {
                System.out.println("Run: " + mainId);
                synchronized (waitObject) {
                    while (mainId > currentMax) {
                        waitObject.wait();
                        System.out.println("Awakened: " + mainId);
                    }

                    currentMax++;
                    System.out.println("Finished: " + mainId);
                    waitObject.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
