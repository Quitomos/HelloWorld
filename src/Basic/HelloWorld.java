package Basic;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class HelloWorld {
    HelloWorld() {
        a = 2;
    }

    private static int a = 0;
    static {
        a = 1;
    }


    public static void f(int a, int... b) {

    }
    public static void f(int a) {

    }
    public static void f(int[] a) {

    }
    public void f3(int a) {

    }
    public void f2() {
        a = 1;
        f3(1);
    }
//    HelloWorld(int a) {
//        this();
//        this.a = a;
//    }
    public static void main(String[] args) {
        //new HelloWorld();
//        Season s = Season.WINTER;
//        System.out.println(s instanceof Season);
//        System.out.println(Season.valueOf("AUTUMN"));
//        switch (s) {
//            case AUTUMN:break;
//            default:break;
//        }
//        String str = "";
//        str += '1';
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy%MM%dd HH:mm:ss");
        System.out.println(sdf.format(date));
        //System.out.println(a);
//        byte b;
//        short s, s2;
//        int i;
//        long l;
//        float f;
//        char c;
//
//        String str;
//        b = 1;
//        s = 1;
//        s2 = s;
//        s += 2.0;
//        i = 1;
//        l = 1;
//        f = 1;
//        c = (char) s;

//        Scanner from_keyboard = new Scanner(System.in);
////        int a = from_keyboard.nextInt();
////        int b = from_keyboard.nextInt();
//
//        //System.out.println(a > b);
//        System.out.println("\n");
//
//        String s = "1 2 3";
//
//        Scanner from_string = new Scanner(s);
//
//        String c = from_string.next();
//        c = from_string.next();
//        //c = from_string.next();
//        boolean b = from_string.hasNext();
//        c = from_string.next();
////        System.out.println(from_string.next());
////        System.out.println(from_string.next());
////        System.out.println(from_string.next());
////        System.out.println(from_string.next());
//
//
//        System.out.println("Hello World");

//        int i = 3;
//        int j = 2;
//        int c = ((i | j) ^ (i & j)) << 2 >>> 1;

//        int i = 1;
//        //i = i + (i++);
//        i = i++ + i;
//        int n = Integer.MAX_VALUE;
//        System.out.println(Math.pow(1+1d/Integer.MAX_VALUE,Integer.MAX_VALUE));
    }
}
