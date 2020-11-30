package DesignPattern;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class AbstractFactoryPattern {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Properties prop = new Properties();
        prop.load(AbstractFactoryPattern.class.getResourceAsStream("Brand.properties"));
        String BRAND = prop.getProperty("BRAND");
        BRAND = "DesignPattern." + BRAND + "Factory";
        AbstractFactory f = (AbstractFactory) Class.forName(BRAND).getConstructor().newInstance();

        AbstractProductA pa = f.getProductA();
        AbstractProductB pb = f.getProductB();
        pa.productAMethod();
        pb.productBMethod();
    }
}

abstract class AbstractProductA {
    abstract void productAMethod();
}

abstract class AbstractProductB {
    abstract void productBMethod();
}

class BrandAProductA extends AbstractProductA {

    @Override
    void productAMethod() {
        System.out.println("Brand A Product A");
    }
}

class BrandBProductA extends AbstractProductA {

    @Override
    void productAMethod() {
        System.out.println("Brand B Product A");
    }
}

class BrandAProductB extends AbstractProductB {

    @Override
    void productBMethod() {
        System.out.println("Brand A Product B");
    }
}

class BrandBProductB extends AbstractProductB {

    @Override
    void productBMethod() {
        System.out.println("Brand B Product B");
    }
}

abstract class AbstractFactory {
    abstract public AbstractProductA getProductA();
    abstract public AbstractProductB getProductB();
}

class BrandAFactory extends AbstractFactory {
    public BrandAFactory() {

    }

    @Override
    public AbstractProductA getProductA() {
        return new BrandAProductA();
    }

    @Override
    public AbstractProductB getProductB() {
        return new BrandAProductB();
    }
}

class BrandBFactory extends AbstractFactory {
    public BrandBFactory() {

    }

    @Override
    public AbstractProductA getProductA() {
        return new BrandBProductA();
    }

    @Override
    public AbstractProductB getProductB() {
        return new BrandBProductB();
    }
}
