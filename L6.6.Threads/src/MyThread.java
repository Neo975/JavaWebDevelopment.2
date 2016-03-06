/**
 * Created by Mike on 06.03.2016.
 */
public class MyThread extends Thread {
    private final int threadID;

    public MyThread(int threadID) {
        this.threadID = threadID;
    }

    @Override
    public void run() {
        System.out.println("MyThread class, info: " + Thread.currentThread().getName() +
                ", thread system id: " + Thread.currentThread().getId() + ", thread instance id: " + threadID);
    }
}
