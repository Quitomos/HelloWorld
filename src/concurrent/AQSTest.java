package concurrent;

import java.util.Random;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class AQSTest {
    public static void main(String[] args) {
        int n = 5;
        Philosopher[] philosophers = new Philosopher[n];
        DinnerAQSLock dinnerAQSLock = new DinnerAQSLock(n);
        for (int i = 0; i < n; ++i) {
            philosophers[i] = new Philosopher(i, dinnerAQSLock);
            philosophers[i].start();
        }
    }
}

//class DinnerAQSLock {
//
//    final Sync sync;
//
//    DinnerAQSLock(int n) {
//        sync = new Sync(n);
//    }
//
//    void lock(int num) {
//        sync.acquireShared(num);
//    }
//
//    void unlock(int num) {
//        sync.releaseShared(num);
//    }
//
//    class Sync extends AbstractQueuedSynchronizer {
//
//        int n;
//
//        Sync(int n) {
//            this.n = n;
//        }
//
//        @Override
//        protected int tryAcquireShared(int arg) {
//            if (arg < 0 || arg >= n)
//                return -1;
//
//            // state 每一位代表一个餐叉，使用掩码来获得对应餐叉的状态
//            int mask = (1 << arg) | (1 << ((arg + 1) % n));
//
//            while (true) {
//                int s = getState();
//
//                // 构造餐叉空闲态
//                int idle = s & ~mask;
//
//                // 构造餐叉新状态
//                int news = s | mask;
//
//                // 如果 CAS 成功，说明餐叉空闲，能够获取锁，且获取锁成功
//                if (compareAndSetState(idle, news))
//                    // 是否有剩余餐叉的判断交给之后的节点自己判断，所以不返回 0
//                    return 1;
//
//                // 如果 CAS 失败，则可能有两种情况
//
//                // 第一种情况：餐叉空闲，由于同时刻其他餐叉状态改变导致的 CAS 失败，自旋
//
//                // 第二种情况：餐叉不空闲，则停止自旋，获取锁失败
//                if ((s & mask) != 0)
//                    break;
//            }
//            return -1;
//        }
//
//        @Override
//        protected boolean tryReleaseShared(int arg) {
//            if (arg < 0 || arg >= n)
//                return false;
//
//            // state 每一位代表一个餐叉，使用掩码来获得对应餐叉的状态
//            int mask = (1 << arg) | (1 << ((arg + 1) % n));
//
//            while (true) {
//                int s = getState();
//                int news = s & ~mask;
//
//                // 自旋直到释放锁成功
//                if (compareAndSetState(s, news))
//                    break;
//            }
//            return true;
//        }
//    }
//}

class Philosopher extends Thread {

    int index;

    DinnerAQSLock DinnerAQSLock;

    Philosopher(int index, DinnerAQSLock DinnerAQSLock) {
        this.index = index;
        this.DinnerAQSLock = DinnerAQSLock;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            sleep(random.nextInt(8000));

            DinnerAQSLock.lock(index);
            eat();
            DinnerAQSLock.unlock(index);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void eat() throws InterruptedException {
        System.out.println("Philosopher " + index + " Eating...");
        sleep(5000);
        System.out.println("Philosopher " + index + " Finish Eating.");
    }
}

class DinnerAQSLock {

    final Sync sync;

    DinnerAQSLock(int n) {
        sync = new Sync(n);
    }

    void lock(int num) {
        sync.acquireShared(num);
    }

    void unlock(int num) {
        sync.releaseShared(num);
    }

    class Sync extends AbstractQueuedSynchronizer {

        int n;

        /**
         * 座位锁
         * 本条件下，每个 Condition 的等待队列最多只有一名哲学家线程挂起
         * 若改为每个座位后有很多哲学家都在排队等着就餐，那么等待队列中会出现多名哲学家线程挂起的情况
         */
        final Condition[] seats;

        Sync(int n) {
            this.n = n;
            seats = new Condition[n];
            for (int i = 0; i < n; ++i) {
                seats[i] = this.new ConditionObject();
            }
        }

        @Override
        protected boolean isHeldExclusively() {
            // 座位锁是独占的，即不能有两位哲学家坐在同一个位置上就餐
            // 座位锁是不可重入的，即一位哲学家不能坐在一个位置上两次
            // 座位锁可以由任意线程释放
            return true;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            if (arg < 0 || arg >= n)
                return -1;

            while (true) {
                // state 每一位代表一个餐叉，使用掩码来获得对应餐叉的状态
                int mask = (1 << arg) | (1 << ((arg + 1) % n));

                int s = getState();

                // 构造餐叉空闲态
                int idle = s & ~mask;

                // 构造餐叉新状态
                int news = s | mask;

                // 如果 CAS 成功，说明餐叉空闲，能够获取锁，且获取锁成功
                if (compareAndSetState(idle, news))
                    // 是否有剩余餐叉的判断交给之后的节点自己判断，所以不返回 0
                    return 1;

                // 如果 CAS 失败，则可能有两种情况

                // 第一种情况：餐叉空闲，由于同时刻其他餐叉状态改变导致的 CAS 失败，则尝试获取锁失败，放入 CLH 队列等待唤醒
                if ((s & mask) == 0) return -1;

                // 第二种情况：餐叉不空闲，放入对应的 Condition 等待队列
                try {
                    seats[arg].await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 唤醒后
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            if (arg < 0 || arg >= n)
                return false;

            // state 每一位代表一个餐叉，使用掩码来获得对应餐叉的状态
            int mask = (1 << arg) | (1 << ((arg + 1) % n));

            while (true) {
                int s = getState();
                int news = s & ~mask;

                // 自旋直到释放锁成功
                if (compareAndSetState(s, news))
                    break;
            }
            return true;
        }
    }
}