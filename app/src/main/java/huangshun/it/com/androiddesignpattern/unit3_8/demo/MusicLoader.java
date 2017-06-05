package huangshun.it.com.androiddesignpattern.unit3_8.demo;

/**
 * Created by hs on 2017/6/3.
 * 练习demo
 */

public class MusicLoader {
    private static MusicLoader mMusicLoader;
    private MusicConfig mMusicConfig;

    public static MusicLoader getInstance() {
        if (mMusicLoader == null) {
            synchronized (MusicLoader.class) {
                if (mMusicLoader == null) {
                    mMusicLoader = new MusicLoader();
                }
            }
        }
        return mMusicLoader;
    }

    public void init(MusicConfig musicConfig) {
        mMusicConfig = musicConfig;
    }

    public void syso() {
        System.out.println(mMusicConfig.toString());
    }
}
