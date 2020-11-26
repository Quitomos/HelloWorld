package DesignPattern;

public class StrategyPattern {
    public static void main(String[] args) {
        Context c = new Context();
        c.execute();
        c.setStrategy(new ConcreteStrategyA());
        c.execute();
        c.setStrategy(new ConcreteStrategyB());
        c.execute();
    }
}

class Context {
    private Strategy s;

    public Context() { s = null; }

    public Context(Strategy s) {
        this.s = s;
    }

    public void setStrategy(Strategy s) {
        this.s = s;
    }

    public void execute() {
        if (s == null) {
            System.out.println("No such strategy!");
        }
        else s.algorithminterface();
    }
}

interface Strategy {
    void algorithminterface();
}

class ConcreteStrategyA implements Strategy {

    @Override
    public void algorithminterface() {
        System.out.println("StrategyA");
    }
}

class ConcreteStrategyB implements Strategy {

    @Override
    public void algorithminterface() {
        System.out.println("StrategyB");
    }
}