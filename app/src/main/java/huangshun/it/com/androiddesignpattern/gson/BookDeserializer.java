package huangshun.it.com.androiddesignpattern.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by hs on 2017/12/21.
 */

public class BookDeserializer implements JsonDeserializer<Book> {
    @Override
    public Book deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement nameElement = jsonObject.get("name");
        String name = nameElement.getAsString();
        JsonElement authorsElement = jsonObject.get("authors");
        Book book = new Book();
        if (authorsElement.isJsonArray()) {//如果是数组
            Author[] authors = context.deserialize(authorsElement, Author[].class);
            book.setAuthors(authors);
        } else {
            book.setAuthors(null);
        }
        book.setName(name);
        return book;
    }
}
