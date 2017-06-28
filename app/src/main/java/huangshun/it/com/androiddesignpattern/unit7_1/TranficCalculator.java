package huangshun.it.com.androiddesignpattern.unit7_1;

/**
 * Created by hs on 2017/6/26.
 */

public class TranficCalculator {
    private CalculateStrategy mCalculateStrategy;

    public static void main(String[] args) {
        TranficCalculator tranficCalculator = new TranficCalculator();
        tranficCalculator.setCalculateStrategy(new BusStrategy());
        tranficCalculator.calculatePriceTranfic(50);
    }

    public void setCalculateStrategy(CalculateStrategy calculateStrategy) {
        mCalculateStrategy = calculateStrategy;
    }

    private int calculatePriceTranfic(int km) {
        return mCalculateStrategy.calculatePrice(km);
    }
}
