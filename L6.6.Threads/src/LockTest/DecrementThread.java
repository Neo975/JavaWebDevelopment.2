package LockTest;

/**
 * Created by user on 07.03.2016.
 */
public class DecrementThread extends Thread {
    private final LockTest lockTest;

    public DecrementThread(LockTest lockTest) {
        this.lockTest = lockTest;
    }

    @Override
    public void run() {
        while(lockTest.getValue() < LockTest.FINAL_VALUE) {
            lockTest.decrementValue();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("DecrementThread has finished. Value: " + lockTest.getValue());
    }
}
