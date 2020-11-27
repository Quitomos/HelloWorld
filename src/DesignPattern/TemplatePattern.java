package DesignPattern;

public class TemplatePattern {
    public static void main(String[] args) {
        new ConcreteMethodA().f();
        new ConcreteMethodB().f();
    }
}

abstract class TemplateMethod {
    public void f() {
        primitiveOperation1();
        primitiveOperation2();
    }

    public abstract void primitiveOperation1();
    public abstract void primitiveOperation2();
}

class ConcreteMethodA extends TemplateMethod {

    @Override
    public void primitiveOperation1() {
        System.out.println("Method A operation 1");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("Method A operation 2");
    }
}

class ConcreteMethodB extends TemplateMethod {

    @Override
    public void primitiveOperation1() {
        System.out.println("Method B operation 1");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("Method B operation 2");
    }
}
