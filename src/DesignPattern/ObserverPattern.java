package DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        concreteSubject2 s = new concreteSubject2();

        s.attach(new concreteObserver(s, "Observer1"));
        s.attach(new concreteObserver(s, "Observer2"));

        concreteObserver o = new concreteObserver(s, "Observer3");
        s.attach(o);

        s.setState("wake");
        s.message();

        s.detach(o);
        s.setState("sleep");
        s.message();
    }
}

abstract class Subject2 {
    private List<Observer> ml = new ArrayList<>();

    abstract public String getState();

    public void attach(Observer o) {
        ml.add(o);
    }

    public void detach(Observer o) {
        ml.remove(o);
    }

    public void message() {
        for (Observer o: ml) {
            o.update();
        }
    }
}

interface Observer {
    void update();
}

class concreteSubject2 extends  Subject2 {
    private String state;
    public concreteSubject2() {
        state = "sleep";
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class concreteObserver implements Observer {
    private Subject2 sub;
    private String name;

    public concreteObserver(Subject2 sub, String s) {
        this.sub = sub;
        this.name = s;
    }

    @Override
    public void update() {
        System.out.println(name + " is notified, subject: " + sub.getState());
    }
}
