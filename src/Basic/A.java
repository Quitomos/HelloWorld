package Basic;

public class A implements Comparable {
    int a;
    public A() {
        this(1);
    }
    public A(int b) {
        a = b;
    }
    public String toString() {
        return String.valueOf(a);
    }

    @Override
    public int compareTo(Object o) {
        return a > ((A)o).a? 1: -1;
    }
}

class B extends A {
    public B() {

    }
    public B(int b) {
        a = b + 1;
    }

}


