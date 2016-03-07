package DeadLock;

/**
 * Created by user on 07.03.2016.
 */
public class DeadLockTester implements Runnable {
    static int nextId = 1;

    private A obj1;
    private A obj2;
    private int id = 0;

    public DeadLockTester(A obj1, A obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        id = nextId++;
    }

    @Override
    public void run() {
        print("Setting value to obj1... ");
        obj1.setValue(id);
        print("done.");
        print("Comparing objects...");
        print("Done. Result: " + ((obj1.equals(obj2)) ? "equal" : "not equal"));
    }

    private void print(String msg) {
        System.out.println("Thread #" + id + ": " + msg);
    }
}
