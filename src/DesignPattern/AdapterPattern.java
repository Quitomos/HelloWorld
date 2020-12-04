package DesignPattern;

public class AdapterPattern {
    public static void main(String[] args) {
        Target t = new AdapterA();
        t.method();
        t = new AdapterB();
        t.method();
    }
}

class AdapteeA {
    public void Amethod() {
        System.out.println("Adaptee A method");
    }
}

class AdapteeB {
    public void Bmethod() {
        System.out.println("Adaptee B method");
    }
}

abstract class Target {
    abstract void method();
}

class AdapterA extends Target {
    private AdapteeA a;
    public AdapterA() {
        this.a = new AdapteeA();
    }

    @Override
    void method() {
        a.Amethod();
    }
}

class AdapterB extends Target {
    private AdapteeB a;
    public AdapterB() {
        this.a = new AdapteeB();
    }

    @Override
    void method() {
        a.Bmethod();
    }
}
