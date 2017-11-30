package huangshun.it.com.androiddesignpattern.test.baodian.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by hs on 2017/11/30.
 */

public class RandomAccessTest {
    private static String path = "/Users/huangshun/Desktop/test/RandomAccessFile";
    private static String channelPath = "/Users/huangshun/Desktop/test/new1";

    public static void main(String[] args) {
        //先在磁盘文件中创建一个指定大小的文件
//        try {
//            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
//            randomAccessFile.setLength(1024 * 1024);
//            randomAccessFile.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = 0; i < 5; i++) {
//            new RandomAccessThread(1024 * i, String.valueOf("我是第" + i + "个字符串").getBytes()).start();
//        }
        //读
//        readRandoAccess();
        //channel
        channelTest();
    }

    //读
    private static void readRandoAccess() {
        byte[] bytes = new byte[22];
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
            int read = randomAccessFile.read(bytes, 0, 22);
            String s = new String(bytes);
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    static class RandomAccessThread extends Thread {
        private int skip;
        private byte[] content;

        public RandomAccessThread(int skip, byte[] content) {
            this.skip = skip;
            this.content = content;
        }

        public void run() {
            RandomAccessFile randomAccessFile = null;
            try {
                randomAccessFile = new RandomAccessFile(path, "rw");
                randomAccessFile.seek(skip);
                randomAccessFile.write(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * channel
     */

    public static void channelTest() {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(channelPath, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(50);
            while (channel.read(buffer) != -1) {
                //当需要读数据时，通过flip()方法把buffer从写模式调整为读模式；在读模式下，可以读取所有已经写入的数据。
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println((char) buffer.get());
                }
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
