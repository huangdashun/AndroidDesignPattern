package huangshun.it.com.androiddesignpattern.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import java.util.List;
import java.util.Random;

import butterknife.ButterKnife;
import huangshun.it.com.androiddesignpattern.R;

public class GreenDao3Activity extends AppCompatActivity {
    private static final String TAG = "GreenDao3Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao3);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "bong.db", null);
        Database writableDb = devOpenHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(writableDb);
        DaoSession daoSession = daoMaster.newSession();

        Random random = new Random();
        UserDao userDao = daoSession.getUserDao();
        for (int i = 0; i < 15; i++) {

            User zhangsan = new User(null, "zhangsan" + random.nextInt(999), "张三");
            userDao.insert(zhangsan);
        }
//    查
        List<User> userList = userDao.queryBuilder()
                .where(UserDao.Properties.Id.between(2, 13)).limit(5).build().list();
        for (User user : userList) {
            Log.i(TAG, user.toString());
        }
//删除
        User user = userDao.queryBuilder().where(UserDao.Properties.Id.eq(6)).build().unique();
        if (user != null) {
            userDao.delete(user);
        } else {
            Log.i(TAG, "用户不存在");
        }
        //更新
        User user7 = userDao.queryBuilder().where(UserDao.Properties.Id.eq(7)).build().unique();
        if (user7 != null) {
            user7.setUsername("huangshun");
            userDao.update(user7);
        }

        User likeuser = userDao.queryBuilder().where(UserDao.Properties.Username.like("hu%")).build().unique();
        Log.i(TAG, "LIKE:" + likeuser.toString());


    }
}
