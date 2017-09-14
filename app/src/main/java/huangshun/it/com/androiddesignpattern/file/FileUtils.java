package huangshun.it.com.androiddesignpattern.file;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import huangshun.it.com.androiddesignpattern.R;

/**
 * Created by hs on 2017/9/8.
 */

public class FileUtils {
    //音乐存放的路径
    public static File getMusicPath(Context context) {
        //当应用被卸载的时候,系统会清理这个目录
        File musicFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        if (musicFilesDir == null) {
            //无法创建文件,请检查权限
            Toast.makeText(context, R.string.not_create_file, Toast.LENGTH_SHORT).show();
            return null;
        } else {
            File bongMusicDir = new File(musicFilesDir.getAbsolutePath() + "/Bong");
            if (bongMusicDir.mkdir() || (bongMusicDir.isDirectory() && bongMusicDir.exists())) {
                return bongMusicDir;
            } else {
                return null;
            }
        }
    }

    //扫描目录下所有的mp3文件
    public static List<String> getLocalMusicList(Context context) {
        File musicPath = getMusicPath(context);
        List<String> musicList = null;
        if (musicPath != null) {
            File[] files = musicPath.listFiles();
            if (files != null && files.length > 0) {
                for (int i = 0; i < files.length; i++) {
                    musicList = new ArrayList<>();
                    if (files[i].getName().endsWith(".mp3")) {//如果是以mp3结尾的音乐
                        musicList.add(files[i].getName());
                    }
                }
            } else {
                return null;
            }
        }
        return musicList;
    }

    //删除目录下的某个文件
    public static Boolean deleteLocalMusic(String musicName, Context context) {
        File musicPath = getMusicPath(context);
        if (musicPath != null) {
            File[] files = musicPath.listFiles();
            if (files != null && files.length > 0) {
                for (int i = 0; i < files.length; i++) {
                    if (musicName.equals(files[i].getName())) {
                        boolean isDelete = files[i].delete();
                        return isDelete;
                    }
                }
            }
        }
        return false;
    }

}
