package Basic;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest2 {
    int j = 1;
    public static void main(String[] args) throws InterruptedException {
        ThreadTest2 test = new ThreadTest2();
        List<Thread> ml = new ArrayList<>();
        for (int i = 0; i < 10000; ++i) {
            ml.add(test.new AddThread());
            ml.add(test.new DecThread());
        }
        for (Thread t: ml) {
            t.start();
        }
        for (Thread t: ml) {
            t.join();
        }
        System.out.println(test.j);
    }
    class AddThread extends Thread {
        public void run() {
            synchronized (ThreadTest2.this) {
                ThreadTest2.this.j++;
            }
        }
    }
    class DecThread extends Thread {
        public void run() {
            synchronized (ThreadTest2.this) {
                ThreadTest2.this.j--;
            }
        }
    }
}
