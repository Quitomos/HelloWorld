package DesignPattern;

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        Handler h3 = new ConcreteHandler3();

        h1.setSucc(h2);
        h2.setSucc(h3);

        h1.handle(1);
        h1.handle(2);
        h1.handle(3);

    }
}

abstract class Handler {
    protected Handler succ;

    public void setSucc(Handler succ) {
        this.succ = succ;
    }

    abstract void handle(int req);
}

class ConcreteHandler1 extends Handler {

    @Override
    void handle(int req) {
        if (req == 1) System.out.println("Handler1 handle req1");
        else succ.handle(req);
    }
}

class ConcreteHandler2 extends Handler {

    @Override
    void handle(int req) {
        if (req == 2) System.out.println("Handler2 handle req2");
        else succ.handle(req);
    }
}

class ConcreteHandler3 extends Handler {

    @Override
    void handle(int req) {
        System.out.println("Handler3 handle req" + req);
    }
}
