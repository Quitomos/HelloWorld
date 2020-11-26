package DesignPattern;

public class ProxyPattern {
    public static void main(String[] args) {
        Proxy p = new Proxy(new RealSubject());

        p.request();
    }
}

interface Subject {
    void request();
}

class RealSubject implements  Subject {

    @Override
    public void request() {
        System.out.println("Real request");
    }
}

class Proxy implements Subject {

    RealSubject s;

    public Proxy(RealSubject s) {
        this.s = s;
    }

    @Override
    public void request() {
        s.request();;
    }
}
