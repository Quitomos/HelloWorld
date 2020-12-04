package DesignPattern;

public class StatePattern {
    public static void main(String[] args) {
        Context2 c = new Context2();
        c.request();
        c.setStr("State C");
        c.request();
        c.setStr("State B");
        c.request();
        c.setStr("State A");
        c.request();
    }
}

class Context2 {
    private State s;
    private String str;

    public Context2() {
        s = new ConcreteStateA();
        str = "State A";
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public State getS() {
        return s;
    }

    public void setS(State s) {
        this.s = s;
    }

    public void request() {
        this.s.handle(this);
    }
}

interface State {
    void handle(Context2 c);
}

class ConcreteStateA implements State {

    @Override
    public void handle(Context2 c) {
        if (c.getStr().compareTo("State A") != 0) {
            c.setS(new ConcreteStateB());
            c.request();
        }
        else {
            System.out.println("State A request");
        }
    }
}

class ConcreteStateB implements State {

    @Override
    public void handle(Context2 c) {
        if (c.getStr().compareTo("State B") != 0) {
            c.setS(new ConcreteStateC());
            c.request();
        }
        else {
            System.out.println("State B request");
        }
    }
}

class ConcreteStateC implements State {

    @Override
    public void handle(Context2 c) {
        if (c.getStr().compareTo("State C") != 0) {
            c.setS(new ConcreteStateA());
            c.request();
        }
        else {
            System.out.println("State C request");
        }
    }
}
