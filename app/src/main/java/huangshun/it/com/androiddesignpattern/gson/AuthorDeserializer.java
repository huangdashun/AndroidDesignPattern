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

public class AuthorDeserializer implements JsonDeserializer<Author> {
    @Override
    public Author deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        int id = jsonObject.get("id").getAsInt();
        String name = jsonObject.get("name").getAsString();
        Author author = new Author();
        author.setId(id);
        author.setName(name);
        return author;
    }
}
