package concurrent;

import java.util.Random;

public class Dinner {

    /**
     * 人数
     */
    int n;

    /**
     * 餐叉锁
     */
    final Object[] forks;

    /**
     * 哲学家
     */
    final Philosopher[] philosophers;

    /**
     * 根据人数构造
     *
     * @param n 人数
     */
    Dinner(int n) {
        this.n = n;
        this.forks = new Object[n];
        for (int i = 0; i < n; ++i) {
            forks[i] = new Object();
        }
        this.philosophers = new Philosopher[n];
        for (int i = 0; i < n; ++i) {
            philosophers[i] = new Philosopher(i);
        }
    }

    class Philosopher extends Thread {

        int index;

        Philosopher(int index) {
            this.index = index;
        }

        /**
         * 获得左手边餐叉锁
         *
         * @return 左手边餐叉锁
         */
        Object getLeft() {
            return forks[index];
        }

        /**
         * 获得右手边餐叉锁
         *
         * @return 右手边餐叉锁
         */
        Object getRight() {
            return forks[(index + 1) % n];
        }

        void eat() throws InterruptedException {
            System.out.println("Philosopher " + index + " Eating...");
            sleep(5000);
            System.out.println("Philosopher " + index + " Finish Eating.");
        }

        @Override
        public void run() {
            try {
                Random random = new Random();
                sleep(random.nextInt(8000));

                if ((index & 1) == 0) {
                    // 偶数号哲学家先获取左手边餐叉，再获取右手边餐叉
                    synchronized (getLeft()) {
                        synchronized (getRight()) {
                            eat();
                        }
                    }
                } else {
                    // 奇数号哲学家先获取右手边餐叉，再获取左手边餐叉
                    synchronized (getRight()) {
                        synchronized (getLeft()) {
                            eat();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void start() {
        for (int i = 0; i < n; ++i) {
            philosophers[i].start();
        }
    }

    public static void main(String[] args) {
        Dinner dinner = new Dinner(5);
        dinner.start();
    }
}
