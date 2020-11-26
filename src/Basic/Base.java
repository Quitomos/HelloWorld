package Basic;

public class Base {
    public int b = 1;
    public void die(mortal m) {
        m.die();
    }
    public Base(int a) {

    }
    public Base() {

    }
    public void f() {
        System.out.println(b);
    }
    public static void main(String[] args) {
        Succ1 s1 = new Succ1(1);
        Succ2 s2 = new Succ2();
        Base b = new Base(1);
        b.die(s1);
        b.die(s2);
        s1.f();
        s2.f();
        b.f();
    }
}
