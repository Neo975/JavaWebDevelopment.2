import DeadLock.A;
import DeadLock.DeadLockTester;
import LockTest.*;

/**
 * Created by Mike on 06.03.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        testMyThread();
//        testVolatile();
//        testSynchro();
        testDeadlock();
    }

    private static void testDeadlock() {
        A a1 = new A();
        A a2 = new A();
        Thread t1 = new Thread(new DeadLockTester(a1, a2));
        Thread t2 = new Thread(new DeadLockTester(a2, a1));
        t1.start();
        t2.start();
    }

    private static void testSynchro() {
        LockTest l = new LockTest();
        IncrementThread incrementThread = new IncrementThread(l);
        DecrementThread decrementThread = new DecrementThread(l);
        incrementThread.start();
        decrementThread.start();
    }

    private static void testVolatile() {
        new VolatileTest.ChangeListener().start();
        new VolatileTest.ChangeMaker().start();
    }

    private static void testMyThread() {
        Thread t0 = new MyThread(0);
        Thread t1 = new MyThread(1);
        Thread t2 = new MyThread(2);
        Thread t3 = new MyThread(3);
        Thread t4 = new MyThread(4);
        Thread t5 = new MyThread(5);
        Thread t6 = new MyThread(6);
        Thread t7 = new MyThread(7);
        Thread t8 = new MyThread(8);
        Thread t9 = new MyThread(9);
        t0.start();
//        t0.join();
        t1.start();
//        t1.join();
        t2.start();
//        t2.join();
        t3.start();
//        t3.join();
        t4.start();
//        t4.join();
        t5.start();
//        t5.join();
        t6.start();
//        t6.join();
        t7.start();
//        t7.join();
        t8.start();
//        t8.join();
        t9.start();
//        t9.join();
    }
}
