package DesignPattern;

public class FacadePattern {
    public static void main(String[] args) {
        Facade f = new Facade();
        f.methodGroupA();
        System.out.print("\n");
        f.methodGroupB();
    }
}

class Facade {
    private SubSystem1 s1;
    private SubSystem2 s2;
    private SubSystem3 s3;

    public Facade() {
        s1 = new SubSystem1();
        s2 = new SubSystem2();
        s3 = new SubSystem3();
    }

    public void methodGroupA() {
        System.out.println("MethodGroupA :");
        s1.method();
        s2.method();
    }

    public void methodGroupB() {
        System.out.println("MethodGroupB :");
        s2.method();
        s3.method();
    }
}

class SubSystem1 {
    public void method() {
        System.out.println("Subsystem1 method");
    }
}

class SubSystem2 {
    public void method() {
        System.out.println("Subsystem2 method");
    }
}

class SubSystem3 {
    public void method() {
        System.out.println("Subsystem3 method");
    }
}
