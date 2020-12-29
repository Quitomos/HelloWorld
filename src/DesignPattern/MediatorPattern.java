package DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class MediatorPattern {
    public static void main(String[] args) {
        Mediator m = new ConcreteMediator();
        Colleague c1 = new ConcreteColleague(m,"c1");
        Colleague c2 = new ConcreteColleague(m,"c2");
        Colleague c3 = new ConcreteColleague(m,"c3");
        m.add(c1);
        m.add(c2);
        m.add(c3);

        c1.send("c1 message");
        c2.send("c2 message");
        c3.send("c3 message");
    }
}

abstract class Mediator {
    protected List<Colleague> ml = new ArrayList<>();
·
    public void add(Colleague c) {
        ml.add(c);
    }

    abstract public void send(Colleague c, String s);
}

class ConcreteMediator extends Mediator {

    @Override
    public void send(Colleague c, String s) {
        System.out.println(c + " send message: " + s);
        for (Colleague col : ml) {
            if (col == c) {
                continue;
            }
            col.receive(s);
        }
    }
}

abstract class Colleague {
    protected String name;
    protected Mediator m;

    public String toString() {
        return name;
    }

    public Colleague(Mediator m, String s) {
        this.m = m;
        name = s;
    }

    abstract void send(String s);

    abstract void receive(String s);
}

class ConcreteColleague extends Colleague {

    public ConcreteColleague(Mediator m, String s) {
        super(m, s);
    }

    @Override
    void send(String s) {
        m.send(this, s);
    }

    @Override
    void receive(String s) {
        System.out.println(this + " receive message: " + s);
    }
}
