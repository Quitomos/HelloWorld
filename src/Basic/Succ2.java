package Basic;

public class Succ2 extends Base implements mortal {
    public Succ2(int a) {
        super(a);
    }
    public Succ2() {

    }
    public void die() {
        System.out.println("Succ2 died");
    }
}
