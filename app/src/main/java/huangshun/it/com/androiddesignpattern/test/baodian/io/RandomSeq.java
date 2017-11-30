package huangshun.it.com.androiddesignpattern.test.baodian.io;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by hs on 2017/11/29.
 */

public class RandomSeq {
    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);

        double lo = Double.valueOf(args[1]);
        double hi = Double.valueOf(args[2]);

        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniform(lo, hi);
            StdOut.printf("%.2f\n", x);
        }
    }
}
