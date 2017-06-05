package huangshun.it.com.androiddesignpattern.unit3_8.demo;

/**
 * Created by hs on 2017/6/3.
 * 音乐配置类
 */

class MusicConfig {
    private int musicCount;//音乐的数量
    private String musicPattern;//音乐的模式

    @Override
    public String toString() {
        return "MusicConfig{" +
                "musicCount=" + musicCount +
                ", musicPattern='" + musicPattern + '\'' +
                '}';
    }

    public static class Build {
        private int musicCount;//音乐的数量
        private String musicPattern;//音乐的模式

        public Build setMusicCount(int musicCount) {
            this.musicCount = musicCount;
            return this;
        }

        public Build setMusicPattern(String musicPattern) {
            this.musicPattern = musicPattern;
            return this;
        }

        public MusicConfig create() {
            MusicConfig config = new MusicConfig();
            apply(config);
            return config;
        }

        private void apply(MusicConfig config) {
            config.musicCount = this.musicCount;
            config.musicPattern = this.musicPattern;
        }
    }
}
