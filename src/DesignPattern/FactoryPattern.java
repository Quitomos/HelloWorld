package DesignPattern;

public class FactoryPattern {
    public static void main(String[] args) {
        CalcultorFactory f = new AddFactory();
        Calcultor c = f.getCalcultor(1, 2);
        System.out.println(c.compute());
    }
}

interface CalcultorFactory {
    Calcultor getCalcultor(int a, int b);
}

class AddFactory implements CalcultorFactory {

    @Override
    public Calcultor getCalcultor(int a, int b) {
        return new Add(a, b);
    }
}

class MinusFactory implements  CalcultorFactory {

    @Override
    public Calcultor getCalcultor(int a, int b) {
        return new Minus(a, b);
    }
}
