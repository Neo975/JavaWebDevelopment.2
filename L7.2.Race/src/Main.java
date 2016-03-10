import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Mike on 10.03.2016.
 */
public class Main {
    private static final int HUNDRED_MILLION = 100_000_000;
//    private static final int HUNDRED_MILLION = 10;
    private static final int THREADS_NUMBER = 2;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUMBER);

        CallCounter counter = new CallCounter();
        AtomicInteger realCountNumber = new AtomicInteger();

        RaceExample callable01 = new RaceExample(counter, realCountNumber);
        RaceExample callable02 = new RaceExample(counter, realCountNumber);

        long startTime = (new Date()).getTime();

        Future<Integer> future01 = executorService.submit(callable01);
        Future<Integer> future02 = executorService.submit(callable02);

        System.out.println("Future01: " + future01.get());
        System.out.println("Future02: " + future02.get());
        System.out.println("RealCountNumber: " + realCountNumber);

        long finishTime = (new Date()).getTime();
        System.out.println("Time spent: " + (finishTime - startTime));
        executorService.shutdown();
    }

    private static class RaceExample implements Callable<Integer> {
        private final AtomicInteger realCountNumber;
        private final CallCounter counter;

        public RaceExample(CallCounter counter, AtomicInteger realCountNumber) {
            this.counter = counter;
            this.realCountNumber = realCountNumber;
        }

        @Override
        public Integer call() throws Exception {
            while(realCountNumber.getAndIncrement() < HUNDRED_MILLION) {
                counter.increment();
            }
            return counter.getCount();
        }
    }
}
