package DesignPattern;

public class PrototypePattern {
    public static void main(String[] args) {
        Prototype p = new Prototype(1);
        Prototype p1 = p.clone();
        Prototype p2 = p.copy();
        p1.setA(2);
        System.out.println(p.getA());
        p2.setA(3);
        System.out.println(p.getA());
    }
}

class testClass {
    public int a;
    public testClass(int a) {
        this.a = a;
    }
}

class Prototype implements Cloneable {
    private testClass A;
    public Prototype(Integer i) {
        A = new testClass(i);
    }

    public Prototype(testClass B) {
        A = B;
    }

    public Integer getA() {
        return A.a;
    }

    public void setA(Integer a) {
        A.a = a;
    }

    public Prototype clone() {
        return new Prototype(A);
    }

    public Prototype copy() {
        return new Prototype(A.a);
    }

}
