package huangshun.it.com.androiddesignpattern.unit17_5;

/**
 * Created by hs on 2017/8/4.
 */

public class GraphicsCard extends Colleague {
    public GraphicsCard(Mediator mediator) {
        super(mediator);
    }

    public void videoPlay(String data) {
        System.out.println("视频: " + data);

    }
}
