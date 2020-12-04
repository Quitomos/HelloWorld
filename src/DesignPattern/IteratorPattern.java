package DesignPattern;

import Basic.A;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class IteratorPattern {
    public static void main(String[] args) {
        ConcreteAggregate c = new ConcreteAggregate();
        for (int i = 0; i < 10; ++i) {
            c.add("str" + i);
        }

        Iterator<String> it = c.createIter();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

interface Aggregate {
    Iterator<String> createIter();
}

class ConcreteAggregate implements Aggregate {
    protected List<String> ml = new ArrayList<>();

    public void add(String s) {
        ml.add(s);
    }

    @Override
    public Iterator<String> createIter() {
        return new ConcreteIter(this);
    }
}

class ConcreteIter implements Iterator<String> {
    private ConcreteAggregate a;
    private int idx;

    public ConcreteIter(ConcreteAggregate a) {
        this.a = a;
        idx = -1;
    }

    @Override
    public boolean hasNext() {
        return idx + 1 != a.ml.size();
    }

    @Override
    public String next() {
        return a.ml.get(++idx);
    }
}
