package Basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.*;

public class Threadtest {
    public static void main(String[] args) {

        Lock l = new ReentrantLock();

        Random r = new Random();
        char c1 = (char)(r.nextInt(26) + 'a');
        char c2 = (char)(r.nextInt(26) + 'a');
        char c3 = (char)(r.nextInt(26) + 'a');

        String pw = String.valueOf(c1) + String.valueOf(c2) + Character.toString(c3);

        Queue<String> mq = new LinkedList<>();


        Thread get_key = new Thread() {
            public void run() {
                getKey(3, mq, pw);
            }
        };

        Thread disp = new Thread() {
            public void run() {
                while (true) {
                    while (!mq.isEmpty()) System.out.println(mq.poll());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (mq.isEmpty()) return;
                }
            }
        };
        disp.setDaemon(true);
        get_key.start();
        disp.start();

        try {
            disp.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n"+ pw);
    }

    private static void getKey(int n, String cur, Queue<String> mq,String key) {
        if (flag) return;
        if (cur.length() == n) {
            mq.offer(cur);
            if (cur.equals(key)) flag = true;
            return;
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            getKey(n, cur + c, mq, key);
        }
    }

    private static void getKey(int n, Queue<String> mq, String key) {
        getKey(n, "", mq, key);
    }

    private static boolean flag = false;
}
