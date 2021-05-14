package concurrent;

public class OrderingTest {
    static int value = 0;
    static boolean state = false;

    public static void write() {
        value = 1;
        state = true;
    }

    public static void read() {
        if (state) {
            System.out.println(value * value * value * value);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            write();
        });
        Thread t2 = new Thread(() -> {
            read();
        });
        t1.start();
        t2.start();
    }
}
