package huangshun.it.com.androiddesignpattern.suanfa.treedemo;

/**
 * Created by hs on 2018/4/1.
 */

public class JobUser {
    private String name;//姓名
    private int jobNumber;//工号
    private int age;//年龄
    private int leaderNumber;//上级员工工号

    public JobUser(String name, int jobNumber, int age, int leaderNumber) {
        this.name = name;
        this.jobNumber = jobNumber;
        this.age = age;
        this.leaderNumber = leaderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLeaderNumber() {
        return leaderNumber;
    }

    public void setLeaderNumber(int leaderNumber) {
        this.leaderNumber = leaderNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", jobNumber=" + jobNumber +
                ", age=" + age +
                ", leaderNumber=" + leaderNumber +
                '}';
    }
}
