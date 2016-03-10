import java.util.Random;

/**
 * Created by user on 10.03.2016.
 */
public class HeavyThread extends Thread {
    private static int countThreads = 0;
    private final int threadId;

    public HeavyThread() {
        threadId = countThreads++;
    }

    @Override
    public void run() {
        Random r = new Random(45);

        for (int i = 0; i < Integer.MAX_VALUE / (threadId + 1); i++) {
            r.nextInt();
        }
    }
}
