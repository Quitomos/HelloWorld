package DesignPattern;

public class DecoratorPattern {
    public static void main(String[] args) {
        Component c = new ConcreteComponent();
        c.operation();
        c = new ConcreteDecoratorA(c);
        c.operation();
        c = new ConcreteDecoratorB(c);
        c.operation();
    }
}

interface Component {
    void operation();
}

class  ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("Basic operation");
    }
}

class Decorator implements Component {
    private Component c = null;

    public Decorator(Component c) {
        this.c = c;
    }

    public void operation() {
        if (c != null) {
            c.operation();
        }
    }
}

class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component c) {
        super(c);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("DecoratorA operation");
    }
}

class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component c) {
        super(c);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("DecoratorB operation");
    }
}
