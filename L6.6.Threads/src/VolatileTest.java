/**
 * Created by Mike on 06.03.2016.
 */

//Java "volatile" keyword test
//Change comments at two strings below for test
public class VolatileTest {
//    private static volatile int MY_INT = 0;
    private static int MY_INT = 0;

    public static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while (local_value < 5) {
                if(local_value != MY_INT) {
                    System.out.println("Got change for MY_INT: " + MY_INT);
                    local_value = MY_INT;
                }
            }
        }
    }

    public static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while (MY_INT < 5) {
                MY_INT = ++local_value;
                System.out.println("Incrementing MY_INT to " + MY_INT);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
