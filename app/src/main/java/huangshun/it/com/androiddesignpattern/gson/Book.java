package huangshun.it.com.androiddesignpattern.gson;

/**
 * Created by hs on 2017/12/21.
 */

public class Book {
    private Author[] authors;
    private String name;

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
