package LockTest;

/**
 * Created by user on 07.03.2016.
 */
public class LockTest {
    private static final int INCREMENT_VALUE = 600;
    private static final int DECREMENT_VALUE = 7;
    public static final int FINAL_VALUE = INCREMENT_VALUE * 5000;
    private volatile int value = 0;
    private Object lockObjectOne = new Object();
    private Object lockObjectTwo = new Object();

    public int getValue() {
        return value;
    }

//Unsynchronized code's block below
    /*
    public void incrementValue() {
        synchronized (lockObjectOne) {
            int localValue = value;
            value += INCREMENT_VALUE;
            if(value != localValue + INCREMENT_VALUE) {
                System.out.println("Unsynchronized action has occured");
            }
        }
    }

    public void decrementValue() {
        synchronized (lockObjectTwo) {
            value -= DECREMENT_VALUE;
        }
    }
*/
//Synchronized code's block below
    public synchronized  void incrementValue() {
        int localValue = value;
        value += INCREMENT_VALUE;
        if(value != localValue + INCREMENT_VALUE) {
            System.out.println("Unsynchronized action has occured");
        }
}

    public synchronized void decrementValue() {
        value -= DECREMENT_VALUE;
    }
}
