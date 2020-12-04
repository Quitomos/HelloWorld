package DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {
    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();
        Element e1 = new ConcreteElementA();
        Element e2 = new ConcreteElementA();
        Element e3 = new ConcreteElementB();
        o.add(e1);
        o.add(e2);
        o.add(e3);

        Visitor v1 = new ConcreteVisitor1();
        Visitor v2 = new ConcreteVisitor2();

        o.visitedBy(v1);
        o.visitedBy(v2);
    }
}

abstract class Element {
    abstract public void accept(Visitor v);
}

class ConcreteElementA extends Element {

    @Override
    public void accept(Visitor v) {
        v.visitA(this);
    }
}

class ConcreteElementB extends Element {

    @Override
    public void accept(Visitor v) {
        v.visitB(this);
    }
}

abstract class Visitor {
    abstract void visitA(ConcreteElementA a);
    abstract void visitB(ConcreteElementB b);
}

class ConcreteVisitor1 extends Visitor {

    @Override
    void visitA(ConcreteElementA a) {
        System.out.println("An elementA is visited by visitor1");
    }

    @Override
    void visitB(ConcreteElementB b) {
        System.out.println("An elementB is visited by visitor1");
    }
}

class ConcreteVisitor2 extends Visitor {

    @Override
    void visitA(ConcreteElementA a) {
        System.out.println("An elementA is visited by visitor2");
    }

    @Override
    void visitB(ConcreteElementB b) {
        System.out.println("An elementB is visited by visitor2");
    }
}

class ObjectStructure {
    private List<Element> ml = new ArrayList<>();

    public void add(Element e) {
        ml.add(e);
    }

    public void visitedBy(Visitor v) {
        for (var e: ml) {
            e.accept(v);
        }
    }
}
