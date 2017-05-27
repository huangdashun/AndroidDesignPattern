package huangshun.it.com.androiddesignpattern.unit1_5;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by hs on 2017/5/27.
 * 关闭closeable对象
 */

public class CloseUtils {
    public void CloseQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
