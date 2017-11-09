package huangshun.it.com.androiddesignpattern.brainview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2017/11/7.
 */

public class BrainViewTest {
    public static void main(String[] args) {
        List<Integer> resultData = new ArrayList<>();
        String str = "D4D26A5052E20000FFFFED9F700F65C50000FFA2FFCB78386A700000D987FFFF822D573F00008F63FFFF8E4E66B100005880FFFF9FCE65CB02A51BDCFFFFB2EC666E21540000FFFFC7F6681F428B0000FFFFDE3B6C795BC10000FFFFF651726769A90000F88CFFFF7B9433160000B299FFFF86CA67CA00007E3AFFFF96A4663500003FD1FFFFA7AA659D0B58082BFFFFBB8A672C2E400000FFFFD10069CE4CEB0000FFFFE7DC6E8362B70000FFFFFE3C75A53B2E0000DBF4FFFF7F4E693D0000A5A0FFFF8D3666C60000659DFFFF9CA965E3007E27E9FFFFAFDC665218600064FFFFC40867DF3B7C0000FFFFD9336B2256B10000FFFFF19E728242AF0000FBAAFFF278FE6A340000CEEBFFFF84F967AB00008BB0FFFF935E665200004BADFFFFA4E8657005821215FFFFB6EB668926880000FFFFCC3568F647400000FFFFE1AC6F99387C0000FFFFF756733A6A270000F30CFFFF7DA169700000B3ADFFFF8A6F6756000070C6FFFF9B1865FE00093239FFFFAD06660F0F9901F6FFFFC217675E32670000FFFFD7246C4223C60000FFFFEAD56FA064A30000FFB0FFDC78876A100000D986FFFF8317680B000098CAFFFF90EF6674000057A7FFFFA18765E701431B01FFFFB50366901DF40000FFFFCBC05D0500CB0000FFFFE0746CB759E70000FFFFFC07749C686A0000F37DFFFF7F8F688A0000B98CFFFF8B00671200007B89";
        System.out.println(str.length());
        List<Integer> mDataList = new ArrayList<>();
        //一共4个字符,先转化为256个数据
        int n = 0;//计算,如果是256正确

        int length = str.length();

        for (int i = 0; i < length; i = i + 4) {
            if (i + 4 <= length) {
                String tmp = str.substring(i, i + 4);
                n++;
                mDataList.add(Integer.valueOf(tmp, 16));
            }
        }

//        for (int i = 0; i < str.length(); i++) {
//            if ((i + 1) * 4 <= str.length()) {
//                String tmp = str.substring(i * 4, (i + 1) * 4);
//                n++;
//                strData.append(tmp);
//                mDataList.add(Integer.valueOf(tmp, 16));
//            }
//        }
        System.out.println("n:" + n);
        int j = 0;
//        for (int i = 1; i < mDataList.size(); i++) {
//            if ((i % 10 == 0)) {
////                String tmp = strData.substring(i * 8, (i + 1) * 8);
//               j++;
//                System.out.println(mDataList.get(i));
////                System.out.println(tmp);
//            }
//        }
        int size = mDataList.size();
        int delta = size / 20;
        for (int i = 0; i < size; i = i + delta) {
            if (resultData.size() < 20) {
                j++;
                resultData.add(mDataList.get(i));
                System.out.println(mDataList.get(i));
            }
        }
        System.out.println("j=" + j);
    }
}
