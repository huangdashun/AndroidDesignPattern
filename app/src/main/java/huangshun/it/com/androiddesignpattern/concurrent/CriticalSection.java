package huangshun.it.com.androiddesignpattern.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hs on 2017/11/12.
 */

public class CriticalSection {
    public static void testApproachees(PairManager pairManager1, PairManager pairManager2) {
        ExecutorService service = Executors.newCachedThreadPool();
        PairManipulator pairManipulator1 = new PairManipulator(pairManager1);
        PairManipulator pairManipulator2 = new PairManipulator(pairManager2);

        PairChecker pairChecker1 = new PairChecker(pairManager1);
        PairChecker pairChecker2 = new PairChecker(pairManager2);

        service.execute(pairManipulator1);
        service.execute(pairManipulator2);
        service.execute(pairChecker1);
        service.execute(pairChecker2);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        System.out.println("pm1: " + pairManipulator1 + "\npm2: " + pairManipulator2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager1 pairManager1 = new PairManager1();
        PairManager2 pairManager2 = new PairManager2();

        testApproachees(pairManager1, pairManager2);
    }
}
