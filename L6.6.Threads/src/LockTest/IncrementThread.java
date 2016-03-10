package LockTest;

/**
 * Created by user on 07.03.2016.
 */
public class IncrementThread extends Thread {
    private final LockTest lockTest;

    public IncrementThread(LockTest lockTest) {
        this.lockTest = lockTest;
    }

    @Override
    public void run() {
        while(lockTest.getValue() < LockTest.FINAL_VALUE) {
            lockTest.incrementValue();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("IncrementThread has finished. Value: " + lockTest.getValue());
    }
}
