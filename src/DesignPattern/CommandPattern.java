package DesignPattern;

public class CommandPattern {
    public static void main(String[] args) {
        Invoker i = new Invoker();
        Receiver r = new Receiver();
        Command c1 = new ConcreteCommand1(r);
        i.setCom(c1);
        i.invoke();

        Command c2 = new ConcreteCommand2(r);
        i.setCom(c2);
        i.invoke();

    }
}

abstract class Command {
    protected Receiver r;

    public Command(Receiver r) {
        this.r = r;
    }

    abstract public void excute();
}

class ConcreteCommand1 extends Command {

    public ConcreteCommand1(Receiver r) {
        super(r);
    }

    @Override
    public void excute() {
        r.action1();
    }
}

class ConcreteCommand2 extends Command {

    public ConcreteCommand2(Receiver r) {
        super(r);
    }

    @Override
    public void excute() {
        r.action2();
    }
}

class Receiver {
    public void action1() {
        System.out.println("Action1");
    }

    public void action2() {
        System.out.println("Action2");
    }
}

class Invoker {
    private Command com;

    public void setCom(Command com) {
        this.com = com;
    }

    public void invoke() {
        if (com != null) com.excute();
    }
}
