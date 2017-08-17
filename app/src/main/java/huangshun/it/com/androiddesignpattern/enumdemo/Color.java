package huangshun.it.com.androiddesignpattern.enumdemo;

/**
 * Created by hs on 2017/8/16.
 */

public enum Color {
    RED, YELLOW, GREEN;

    public void getColor(Color  color) {
        Color otherColor = Color.RED;
        switch (otherColor) {
            case RED:

                break;

            default:
                break;
        }

    }

    public static void main(String[] args) {
        System.out.println(RED);
    }
}