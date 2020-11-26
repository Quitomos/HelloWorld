package Basic;

public class Succ1 extends Base implements mortal{
    public Succ1(int a) {
        super(a);
    }
    public Succ1() {

    }
    public int b = 2;
//    public void f() {
//        System.out.println(b);
//    }
    public void die() {
        System.out.println("Succ1 died");
    }
    public static void main(String[] args) {
        Base base = new Succ1();
        base.f();
        Succ1 s1 = new Succ1();
        s1.f();
    }
}
