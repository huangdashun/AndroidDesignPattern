package huangshun.it.com.androiddesignpattern.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2017/7/31.
 */

public class Test {
    public static void main(String[] args) {
//        threadTest();
//        assertTest();
//        testArrayList();
//        listProxy();
//        byteBufferTest1();
//        byteBufferTest2();
//        testBufferOrder();
        System.out.println(exceptionTest().getName());
    }

    static class Obj {
        private String name;

        public String getName() {
            return name;
        }
    }

    private static Obj exceptionTest() {
        Obj mObj = new Obj();

        try {
            mObj.name = "zhangsan";
            return mObj;
        } catch (Exception e) {

        } finally {
            mObj.name = "lisi";
        }
        return null;
    }

    private static void testBufferOrder() {
        System.out.println("当前系统order=" + ByteOrder.nativeOrder());

        ByteBuffer buffer = ByteBuffer.allocate(20);

        // 获取默认的byte顺序
        ByteOrder order = buffer.order(); //
        System.out.println("当前order=" + order);
        System.out.println(new String(buffer.array()));
        buffer.putShort(0, (short) 1);
        buffer.get(0);
        System.out.println("此时取出0:" + buffer.get(0));
        buffer.get(1);
        System.out.println("此时取出1:" + buffer.get(1));
        System.out.println(new String(buffer.array()));
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println("当前order=" + buffer.order());
        System.out.println(new String(buffer.array()));
        buffer.putShort(0, (short) 1);
        buffer.get(0);
        System.out.println("此时取出1:" + buffer.get(0));
        buffer.get(1);
        System.out.println("此时取出0:" + buffer.get(1));
        System.out.println(new String(buffer.array()));
    }

    private static void byteBufferTest2() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        byteBuffer.put((byte) 'a').put((byte) 'b')
                .put((byte) 'c');
//
//        System.out.println("bigOrder:" + (char) byteBuffer.get(0));

        System.out.println(new String(byteBuffer.array()));
//        ByteBuffer littleOrder = byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(0, (byte) 'd');
//        System.out.println("LITTLE_ENDIAN:" + (char) littleOrder.get(0));
        System.out.println(new String(byteBuffer.array()));


    }

    private static void byteBufferTest1() {
        System.out.println("----------Test allocate--------");
        System.out.println("before allocate:"
                + Runtime.getRuntime().freeMemory());
        ByteBuffer buffer = ByteBuffer.allocate(102400);
        System.out.println("buffer:" + buffer);

        System.out.println("after allocate:" + Runtime.getRuntime().freeMemory());

        //这部分直接用的系统内存，所以对JVM的内存没有影响
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(102400);
        System.out.println("direct buffer:" + allocateDirect);
        System.out.println("after direct allocate:" + Runtime.getRuntime().freeMemory());


        System.out.println("-----------Test wrap----------");
        byte[] bytes = new byte[32];
        buffer = ByteBuffer.wrap(bytes);
        System.out.println(buffer);//0   32   32

        buffer = ByteBuffer.wrap(bytes, 10, 10);// 10   20    32

        System.out.println(buffer);

        System.out.println("----------Test reset ----------");

        buffer.clear();

        buffer.position(5);
        buffer.mark();
        buffer.position(10);
        System.out.println("before reset:" + buffer);// 10  32   32

        buffer.reset();
        System.out.println("after reset:" + buffer);// 5   32   32

        System.out.println("----------Test rewind ----------");
        buffer.clear();
        buffer.position(10);
        buffer.limit(15);
        System.out.println("before rewind:" + buffer);//10   15  32
        buffer.rewind();
        System.out.println("before rewind:" + buffer);//0  15  32


        System.out.println("--------Test compact--------");
        buffer.clear();
        buffer.put("abcd".getBytes());
        System.out.println("before compact:" + buffer);// 4  32  32
        System.out.println(new String(buffer.array()));
        buffer.flip();
        System.out.println("after flip:" + buffer); // 0  4  32

        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());
        System.out.println("after three gets:" + buffer);// 3  4  32
        System.out.println("\t" + new String(buffer.array()));
        buffer.compact();
        System.out.println("after compact:" + buffer);// 1   32     32
        System.out.println("\t" + new String(buffer.array()));//dbcd

        System.out.println("------Test get-------------");
        buffer = ByteBuffer.allocate(32);
        buffer.put((byte) 'a').put((byte) 'b').put((byte) 'c').put((byte) 'd')
                .put((byte) 'e').put((byte) 'f');
        System.out.println("before flip()" + buffer);//6   32  32

        // 转换为读取模式
        buffer.flip();
        System.out.println("before get():" + buffer);// 0    6  32
        System.out.println((char) buffer.get());
        System.out.println("after get():" + buffer);//1   6  32
        // get(index)不影响position的值
        System.out.println((char) buffer.get(2));// c
        System.out.println("after get(index):" + buffer);//1    6   32
        //会影响position的位置
        byte[] dst = new byte[10];
        buffer.get(dst, 0, 2);
        System.out.println("after get(dst, 0, 2):" + buffer);// 3   6  32
        System.out.println("\t dst:" + new String(dst));//  b  c
        System.out.println("buffer now is:" + buffer);// 3  6  32
        System.out.println("\t" + new String(buffer.array()));//  abcdef....

        System.out.println("--------Test put-------");
        ByteBuffer bb = ByteBuffer.allocate(32);
        System.out.println("before put(byte):" + bb);// 0   32  32
        System.out.println(new String(bb.array()));
        System.out.println("after put(byte):" + bb.put((byte) 'z'));//  1  32  32
        // put(2,(byte) 'c')不改变position的位置
        System.out.println("\t" + bb.put(2, (byte) 'c'));
        System.out.println("after put(2,(byte) 'c'):" + bb);//  1   32   32
        System.out.println("\t" + new String(bb.array()));//z c                             


        System.out.println("before buffer:" + buffer);//3   6  32
        bb.put(buffer);//用相对写，把src中可读的部分（也就是position到limit）写入此byteBuffer
        System.out.println("after buffer:" + buffer);// 6   6  32
        System.out.println("\t" + new String(buffer.array()));
        System.out.println("after put(buffer):" + bb);//4   32   32
        System.out.println("\t" + new String(bb.array()));


    }

    private static void testArrayList() {
        List<Integer> mList = new ArrayList<>();
        mList.add(0, 1);
        mList.add(0, 2);
        mList.add(0, 3);
        mList.add(0, 4);

        for (int i = 0; i < mList.size(); i++) {
            System.out.println(mList.get(i));
        }

    }

    private static void assertTest() {
        int a = -3;
        assert a >= 0 : "negative index in method";
    }

    private static void threadTest() {
        //三个锁

        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Thread aThread = new Thread(new ThreadTest("A", c, a));
        Thread bThread = new Thread(new ThreadTest("B", a, b));
        Thread cThread = new Thread(new ThreadTest("C", b, c));

        aThread.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        bThread.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        cThread.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


    private static void listProxy() {
        List<String> list = new ArrayList<>();
        List<String> proxyInstance = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(list, args);
                    }
                });
        proxyInstance.add("你好");
        System.out.println(list);
    }
}
