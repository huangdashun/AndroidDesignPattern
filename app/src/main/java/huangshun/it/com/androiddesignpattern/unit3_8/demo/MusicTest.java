package huangshun.it.com.androiddesignpattern.unit3_8.demo;

/**
 * Created by hs on 2017/6/3.
 */

public class MusicTest {
    public static void main(String[] args) {
        MusicConfig config = new MusicConfig.Build()
                .setMusicCount(4)
                .setMusicPattern("随机模式")
                .create();
        MusicLoader.getInstance().init(config);
        MusicLoader.getInstance().syso();
    }
}
