package huangshun.it.com.androiddesignpattern.test.baodian.concurrent.deadlock;

/**
 * Created by hs on 2017/12/5.
 * 动态的锁顺序死锁
 */

public class DynamicLockTest {
    private final static Object mLock = new Object();
    //存取款帮助类
    private static Helper mHelper = new Helper();

    public static void main(String[] args) {
        Account fromAccount = new Account();
        Account toAccount = new Account();
        for (int i = 0; i < 2500; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    transferMoney(fromAccount, toAccount, 50);
                    transferMoney(toAccount, fromAccount, 50);
                }
            }).start();
        }

    }

    private static void transferMoney(Account from, Account to, double amount) {
//        可能发生发生死锁
//        synchronized (from) {
//            synchronized (to) {
////                mHelper.transfer(from, to, amount);
//                System.out.println("进行了存取款");
//            }
//        }
//        解决动态的锁顺序
        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);
        if (fromHash < toHash) {
            synchronized (from) {
                synchronized (to) {
//                    mHelper.transfer(from, to, amount);
                    System.out.println("进行了存取款");
                }
            }
        } else if (fromHash > toHash) {
            synchronized (to) {
                synchronized (from) {
//                    mHelper.transfer(from, to, amount);
                    System.out.println("进行了存取款");
                }
            }
        } else {
            synchronized (mLock) {
                synchronized (from) {
                    synchronized (to) {
//                        mHelper.transfer(from, to, amount);
                        System.out.println("进行了存取款");
                    }
                }
            }
        }

    }

    //账户类
    static class Account {
        private static double money = 100;

        public static void add(double amount) {
            money = money + amount;
            System.out.println("add money:" + money);
        }

        public static void reduce(double amount) {
            money = money - amount;
            System.out.println("reduce money:" + money);
        }
    }

    //存取款帮助类
    static class Helper {

        private void transfer(Account fromAccount, Account toAccount, double amount) {
            fromAccount.add(amount);
            toAccount.reduce(amount);
        }
    }
}
