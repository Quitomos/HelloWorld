package Basic;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.*;
import java.util.stream.Collectors;

public class A implements Comparable {
    int a;

    public A() {
        this(1);
    }
    public A(int b) {
        a = b;
    }
    public String toString() {
        return String.valueOf(a);
    }

    @Override
    public int compareTo(Object o) {
        return a > ((A)o).a? 1: -1;
    }

    static void f() {
        System.out.println("A");
    }
    static int d = 1;

    void f2() {
        System.out.println("A");
    }

    void f3(Integer i) {
        ++i;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //        Class c = Class.forName("Basic.B");
        //        B b = new B();
        //        Field f = c.getDeclaredField("c");
        //        f.setAccessible(true);
        //        f.set(b, 1);
        //        c.getConstructor().newInstance();
        //        c.getConstructor();
        //        List<? super A> ml = new ArrayList<>();
        //        ml.add(new A());
        //        List<? extends A> ml2 = new ArrayList<>();
        //        A a = new B();
        //        String s1 = "abc";
        //        String s2 = "abc";
        //        String s3 = new String("abc");
        //        System.out.println(s1 == s2);
        //        System.out.println(s1 == s3);
        //        System.out.println(s1.equals(s3));
        //
        //        Map<Integer, Integer> mm = new HashMap<>();
        //        for (int i = 0; i < 5; ++i) {
        //            mm.put(i, i);
        //        }
        //        Iterator<Map.Entry<Integer, Integer>> it = mm.entrySet().iterator();
        //        while (it.hasNext()) {
        //            var e = it.next();
        //            mm.remove(e.getKey());
        //        }
        //        Integer i = 101;
        //        Integer j = 101;
        //        System.out.println(i == j);
//        Integer a = 1;
//        String s = "";
//        new A().f3(a);
//        System.out.println(a);
//        StringBuilder sb = new StringBuilder();
//        Deque ms = new ArrayDeque();
//        ArrayList ml = new ArrayList();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        ArrayList<Integer> a2 = (ArrayList<Integer>) a1.clone();
        a2.set(0, 2);
        System.out.println(a1);
        System.out.println(a2);
        Deque<Integer> ms = new ArrayDeque<>();
        String a = "a";
        ForkJoinPool pp = (ForkJoinPool) Executors.newWorkStealingPool();

    }
}

//class B extends A {
//
//    private int c = 0;
//    public B() {
//
//    }
//    public B(int b) {
//        a = b + 1;
//    }
//    void f2() {
//        System.out.println("B");
////        d += 2;
//    }
//
//
//    class C {
//        void fc() {
//            c = 1;
//            B.this.c = 1;
//            System.out.println(c);
//        }
//    }
//}


