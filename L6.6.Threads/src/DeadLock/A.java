package DeadLock;

/**
 * Created by user on 07.03.2016.
 */
public class A {
    private int value = 0;

    synchronized void setValue(int value) {
        this.value = value;
    }

    synchronized int getValue() {
        return value;
    }

    @Override
    public synchronized boolean equals(Object o) {
        A a = (A) o;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value == a.getValue();
    }
}
