package concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bathing {

    final Semaphore womanMutex, manMutex, bathMutex;

    int womanNum, manNum;

    Bathing() {
        this.womanMutex = new Semaphore(1);
        this.manMutex = new Semaphore(1);
        this.bathMutex = new Semaphore(1);

        womanNum = 0;
        manNum = 0;
    }

    class Woman extends Thread {
        @Override
        public void run() {
            try {
                // 获取女性数量锁
                womanMutex.acquire();
                // 第一名女性获取浴室锁
                if (++womanNum == 1)
                    bathMutex.acquire();

                womanMutex.release();

                // 洗浴
                System.out.println("Woman Bathing...");
                sleep(3000);
                System.out.println("Woman Finish Bathing");

                womanMutex.acquire();
                // 最后一名女性释放浴室锁
                if (--womanNum == 0)
                    bathMutex.release();

                womanMutex.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Man extends Thread {
        @Override
        public void run() {
            try {
                // 获取男性数量锁
                manMutex.acquire();
                // 第一名男性获取浴室锁
                if (++manNum == 1)
                    bathMutex.acquire();

                manMutex.release();

                // 洗浴
                System.out.println("Man Bathing...");
                sleep(3000);
                System.out.println("Man Finish Bathing");

                manMutex.acquire();
                // 最后一名男性释放浴室锁
                if (--manNum == 0)
                    bathMutex.release();

                manMutex.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Bathing bathing = new Bathing();
        int womanNum = 10, manNum = 10;
        new Thread(() -> {
            Random random = new Random();
            int cnt = womanNum;
            while (cnt-- > 0) {
                try {
                    Thread.sleep(random.nextInt(5000));
                    bathing.new Woman().start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            Random random = new Random();
            int cnt = manNum;
            while (cnt-- > 0) {
                try {
                    Thread.sleep(random.nextInt(5000));
                    bathing.new Man().start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
