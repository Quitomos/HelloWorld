package DesignPattern;

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s == s2);
    }
}

class Singleton {
    private static Singleton s;

    private Singleton() {}

    public int a;

    public static Singleton getInstance() {
        if (s == null) {
            s = new Singleton();
        }
        return s;
    }
}
