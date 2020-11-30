package DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class BuilderPattern {
    public static void main(String[] args) {
        Builder b = new ConcreteBuilder();
        Product p = b.getProduct();
        p.getParts();
        Director d = new Director();
        d.constuct(b);
        p.getParts();
    }
}

class Product {
    private List<String> parts;
    public Product() {
        parts = new ArrayList<>();
    }

    public void addPart(String s) {
        parts.add(s);
    }

    public void getParts() {
        System.out.println(parts);
    }
}

interface Builder {
    void buildPartA();
    void buildPartB();
    Product getProduct();
}

class ConcreteBuilder implements Builder {

    private Product p;

    public ConcreteBuilder() {
        p = new Product();
    }

    @Override
    public void buildPartA() {
        p.addPart("A");
    }

    @Override
    public void buildPartB() {
        p.addPart("B");
    }

    @Override
    public Product getProduct() {
        return p;
    }
}

class Director {
    public void constuct(Builder b) {
        b.buildPartA();
        b.buildPartB();
    }
}
