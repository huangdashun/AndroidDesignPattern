package huangshun.it.com.androiddesignpattern.suanfa.treedemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2018/4/1.
 */

public class Test {

    private static Tree<JobUser> sTree;

    public static void main(String[] args) {
        //模拟从文件读取的列表
        JobUser hs = new JobUser("黄顺", 1, 23, 7);
        JobUser syy = new JobUser("司衍悦", 2, 24, 7);
        JobUser zyy = new JobUser("张玉颖", 3, 24, 7);
        JobUser ld = new JobUser("习大大", 7, 50, 0);
        JobUser zs = new JobUser("张三", 4, 25, 3);
        JobUser ls = new JobUser("李四", 5, 25, 3);
        JobUser wangEr = new JobUser("王二", 6, 25, 3);
        List<JobUser> jobUsers = new ArrayList<>();
        jobUsers.add(hs);
        jobUsers.add(syy);
        jobUsers.add(zyy);
        jobUsers.add(ld);
        jobUsers.add(zs);
        jobUsers.add(ls);
        jobUsers.add(wangEr);

        //需要遍历找出老大
        for (int i = 0; i < jobUsers.size(); i++) {
            JobUser jobUser = jobUsers.get(i);
            if (jobUser.getLeaderNumber() == 0) {//说明找到了老大
                sTree = new Tree(jobUser);
                jobUsers.remove(jobUser);
                break;
            }
        }
        if (jobUsers.size() == 0) {
            return;
        }
        for (int i = 0; i < jobUsers.size(); i++) {
            JobUser jobUser = jobUsers.get(i);
            if (jobUser.getLeaderNumber() == sTree.getRoot().getData().getJobNumber()) {
                Tree.Node<JobUser> node = new Tree.Node<>();
                node.setData(jobUser);
                sTree.getRoot().getChildren().add(node);

            }
        }


    }

    private static void addUser(int leaderNumber) {

    }
}
