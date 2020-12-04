package DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        Component2 root = new Composite("root");
        root.add(new Leaf("leaf1"));

        Component2 comp = new Composite("comp1");
        comp.add(new Leaf("leaf2"));
        comp.add(new Leaf("leaf3"));
        root.add(comp);

        root.display(1);
    }
}

interface Component2 {
    void add(Component2 c);
    void remove(Component2 c);
    void display(int d);
}

class Leaf implements Component2 {
    private String name;

    public Leaf(String s) {
        name = s;
    }

    @Override
    public void add(Component2 c) {

    }

    @Override
    public void remove(Component2 c) {

    }

    @Override
    public void display(int d) {
        System.out.println("-".repeat(d) + name);
    }
}

class Composite implements Component2 {
    private String name;
    List<Component2> succ = new ArrayList<>();

    public Composite(String s) {
        name = s;
    }

    @Override
    public void add(Component2 c) {
        succ.add(c);
    }

    @Override
    public void remove(Component2 c) {
        succ.remove(c);
    }

    @Override
    public void display(int d) {
        System.out.println("-".repeat(d) + name);
        for (var su: succ) {
            su.display(d + 1);
        }
    }
}
