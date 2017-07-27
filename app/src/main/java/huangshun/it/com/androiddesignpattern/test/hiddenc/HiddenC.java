package huangshun.it.com.androiddesignpattern.test.hiddenc;

/**
 * Created by hs on 2017/7/26.
 */


class C implements A {
    public void f() {
        System.out.println("public C.f()");
    }

    public void g() {
        System.out.println("public C.g()");
    }

    void u() {
        System.out.println("package C.u()");
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}

public class HiddenC {
    public static C makeA() {
        return new C();
    }
} ///:~