package DesignPattern;

public class SimpleFactoryPattern {
    public static void main(String[] args) {
        Calcultor a = CalcultorSimpleFactory.getCalcultor(2,1,2);
        if (a != null) {
            System.out.println(a.compute());
        }
    }
}

class CalcultorSimpleFactory {
    public static Calcultor getCalcultor(int i, int a, int b) {
        switch (i) {
            case 0: return new Add(a, b);
            case 1: return new Minus(a, b);
            default: System.out.println("Wrong type!");
                return null;
        }
    }
}

abstract class Calcultor {
    protected int a, b;
    public Calcultor(int a, int b) {
        this. a = a;
        this.b = b;
    }
    abstract public int compute();

}

class Add extends Calcultor {
    public Add(int a, int b) {
        super(a, b);
    }
    public int compute() {
        return a + b;
    }
}

class Minus extends Calcultor {
    public Minus(int a, int b) {
        super(a, b);
    }
    public int compute() {
        return a - b;
    }
}
