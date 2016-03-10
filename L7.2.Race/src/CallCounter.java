/**
 * Created by Mike on 10.03.2016.
 */
public class CallCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
