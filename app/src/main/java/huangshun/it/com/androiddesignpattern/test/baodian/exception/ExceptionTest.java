package huangshun.it.com.androiddesignpattern.test.baodian.exception;

/**
 * Created by hs on 2017/12/2.
 */

public class ExceptionTest {
    public static void main(String[] args) throws MyException {
//        test1();
        try {
            test2();
        } catch (MyException e) {
            System.out.println("Catch My Exception");
            e.printStackTrace();
        }

    }

    private static void test2() throws MyException {
        try {
            int i = 10 / 0;
        } catch (ArithmeticException e) {
            throw new MyException("This  is MyException");
        }
    }

    private static void test1() {
        try {
            int i = 10 / 0;
            System.out.println("i=" + i);//不会执行到
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception");
            System.out.println("e.getMessage():" + e.getMessage());
            System.out.println("e.toString():" + e.toString());
            System.out.println("e.printStackTrace():");
            //在命令行打印异常信息在程序中出错的位置及原因
            e.printStackTrace();
        } finally {
            System.out.println("run finally");
        }
    }

    static class MyException extends Exception {
        public MyException() {

        }

        public MyException(String msg) {
            super(msg);
        }
    }
}
