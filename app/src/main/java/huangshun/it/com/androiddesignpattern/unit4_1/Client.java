package huangshun.it.com.androiddesignpattern.unit4_1;

/**
 * Created by hs on 2017/6/5.
 */

public class Client {
    public static void main(String[] args) {
        WordDocument originDoc = new WordDocument();
        originDoc.setText("这是一篇文档");
        originDoc.setImages("图片1");
        originDoc.setImages("图片2");
        originDoc.setImages("图片3");
        originDoc.showDocument();
        //以原始文档为原型,拷贝一份副本
        WordDocument cloneDoc = originDoc.clone();
        cloneDoc.showDocument();
        cloneDoc.setText("这是修改过的Doc2文本");
        cloneDoc.setImages("哈哈");
        cloneDoc.showDocument();
        originDoc.showDocument();
    }
}
