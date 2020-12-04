package DesignPattern;

public class BridgePattern {
    public static void main(String[] args) {
        Abstraction a1 = new RefinedAbstraction1();
        a1.setImp(new Imp1());
        Abstraction a2 = new RefinedAbstraction2();
        a2.setImp(new Imp2());

        a1.operation();
        a2.operation();
    }
}

abstract class Abstraction {
    protected Implementor i;

    public void setImp(Implementor i) {
        this.i = i;
    }

    public abstract void operation();
}

class RefinedAbstraction1 extends  Abstraction {

    @Override
    public void operation() {
        System.out.print("RefinedAbstraction1: ");
        if (i != null) i.impOperation();
    }
}

class RefinedAbstraction2 extends  Abstraction {

    @Override
    public void operation() {
        System.out.print("RefinedAbstraction2: ");
        if (i != null) i.impOperation();
    }
}

abstract class Implementor {
    public abstract void impOperation();
}

class Imp1 extends Implementor {

    @Override
    public void impOperation() {
        System.out.println("Imp1 operation");
    }
}

class Imp2 extends Implementor {

    @Override
    public void impOperation() {
        System.out.println("Imp2 operation");
    }
}
