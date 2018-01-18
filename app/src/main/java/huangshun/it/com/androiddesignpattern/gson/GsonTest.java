package huangshun.it.com.androiddesignpattern.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by hs on 2017/12/21.
 */

public class GsonTest {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().
                registerTypeAdapter(Book.class, new BookDeserializer())
                .registerTypeAdapter(Author.class, new AuthorDeserializer())
                .create();

//        String str = "{ \"name\":\"java书籍\", \"authors\":[{\"id\":5,\"name\":\"Tome\"}, {\"id\":6,\"name\":\"Jerry\"}]}";
        String str = "{ \"name\":\"java书籍\", \"authors\":\"\"}";
        Book book = gson.fromJson(str, Book.class);
        String json = gson.toJson(book);
        System.out.println(json);
    }

}
