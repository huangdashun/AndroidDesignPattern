package huangshun.it.com.androiddesignpattern.unit4_1;

import java.util.ArrayList;

/**
 * Created by hs on 2017/6/5.
 */

public class WordDocument implements Cloneable {
    //文本
    private String mText;
    //图片名列表
    private ArrayList<String> mImages = new ArrayList<>();

    public WordDocument() {
        System.out.println("---------- WordDocument函数 ----------");
    }

    @Override
    protected WordDocument clone() {
        try {
            WordDocument doc = (WordDocument) super.clone();
            doc.mText = this.mText;
            doc.mImages = (ArrayList<String>) this.mImages.clone();//深拷贝
            return doc;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public ArrayList<String> getImages() {
        return mImages;
    }

    public void setImages(String img) {
        mImages.add(img);
    }

    /**
     * 打印文档内容
     */
    public void showDocument() {
        System.out.println("---------- Word Content Start ----------");
        System.out.println("Text : " + mText);
        System.out.println("Images List: ");
        for (String imageName : mImages) {
            System.out.println("Image name :" + imageName);
        }
        System.out.println("---------- Word Content End ----------");
    }
}
