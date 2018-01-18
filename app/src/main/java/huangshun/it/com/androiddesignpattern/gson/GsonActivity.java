package huangshun.it.com.androiddesignpattern.gson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import huangshun.it.com.androiddesignpattern.R;

public class GsonActivity extends AppCompatActivity {
    private static final String TAG = "GsonActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        parseData();
        productData();
        productUserJson();
        parseUserData();
        productJsonArray();
    }

    public static <T> Result<T> fromJsonObject(Reader reader, Class<T> clazz) {
        Gson gson = new Gson();
        Type type = new ParameterizedTypeImpl(Result.class, new Class[]{clazz});
        return gson.fromJson(reader, type);

    }

    public static <T> Result<T> fromJsonArray(Reader reader, Class<T> clazz) {
        Gson gson = new Gson();
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        Type type = new ParameterizedTypeImpl(Result.class, new Type[]{listType});
        return gson.fromJson(reader, type);
    }

    private void productJsonArray() {
        Gson gson = new Gson();
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {
        }.getType());

    }

    private void parseUserData() {
        Gson gson = new Gson();
        String jsonString = "{\"name\":\"是我啊\",\"age\":12}";
        User user = gson.fromJson(jsonString, User.class);
        Log.i(TAG, "user:" + user.toString());
    }

    private void productUserJson() {
        Gson gson = new Gson();
        User user = new User("啊哈哈", 12);
        String userJson = gson.toJson(user);
        Log.i(TAG, "userJson:" + userJson);
    }

    /**
     * 基本数据类型的生成
     */
    private void productData() {
        Gson gson = new Gson();
        String jsonNumber = gson.toJson(100);
        String jsonBoolean = gson.toJson(false);
        String jsonString = gson.toJson("String");
    }

    /**
     * 基本数据类型的解析
     */
    private void parseData() {
        Gson gson = new Gson();
        int i = gson.fromJson("100", int.class);
        double d = gson.fromJson("\"99.99\"", Double.class);
        boolean b = gson.fromJson("true", boolean.class);
        String str = gson.fromJson("String", String.class);

    }
}
