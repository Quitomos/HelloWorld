package DesignPattern;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class FlyweightPattern {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        FlyweightFactory f = new FlyweightFactory();
        Flyweight f1 = f.getFlyweight(1);
        f1.operation(1);
        Flyweight f2 = f.getFlyweight(1);
        f2.operation(2);
        System.out.println(f1 == f2);

        Flyweight f3 = f.getFlyweight(2);
        f3.operation(1);
        Flyweight f4 = f.getFlyweight(2);
        f4.operation(2);
        System.out.println(f3 == f4);
    }
}

abstract class Flyweight {
    abstract void operation(int id);
}

class ConcreteFlyweight1 extends Flyweight {

    @Override
    void operation(int id) {
        System.out.println("Flyweight1, id: " + id);
    }
}

class ConcreteFlyweight2 extends Flyweight {

    @Override
    void operation(int id) {
        System.out.println("Flyweight2, id: " + id);
    }
}

class FlyweightFactory {
    private Map<Integer, Flyweight> mm = new HashMap<>();

    Flyweight getFlyweight(int key) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (!mm.containsKey(key))
            mm.put(key, (Flyweight)Class.forName("DesignPattern.ConcreteFlyweight" + key).getDeclaredConstructor().newInstance());
        return mm.get(key);
    }
}
