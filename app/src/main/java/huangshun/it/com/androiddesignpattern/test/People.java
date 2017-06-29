package huangshun.it.com.androiddesignpattern.test;

import static huangshun.it.com.androiddesignpattern.test.People.Teacher.teacherNumber;

/**
 * Created by hs on 2017/5/26.
 */

public interface People {
    class Teacher {
        static int teacherNumber = 23;
    }

     class Student {
        int studentNumber = 32;

        static int getTotalNumber() {
            return teacherNumber;
        }
    }
}
