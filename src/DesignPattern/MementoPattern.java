package DesignPattern;

public class MementoPattern {
    public static void main(String[] args) {
        Originator o = new Originator();
        o.setState("State 1");
        Caretaker c = new Caretaker(o.creatMemento());
        System.out.println(o.getState());
        o.setState("State 2");
        System.out.println(o.getState());
        o.setMemento(c.getMemento());
        System.out.println(o.getState());
    }
}

class Originator {
    private String state;

    public Memento creatMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento m) {
        this.state = m.getState();
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Memento {
    private String state;

    public Memento(String s) {
        state = s;
    }

    public String getState() {
        return state;
    }
}

class Caretaker {
    private Memento m;

    public Caretaker(Memento m) {
        this.m = m;
    }

    public Memento getMemento() {
        return m;
    }
}
