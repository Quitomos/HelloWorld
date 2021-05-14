package concurrent;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ConcurrentStack<T> {

    /**
     * 生产者信号量
     */
    private final Semaphore pushSemaphore;

    /**
     * 消费者信号量
     */
    private final Semaphore popSemaphore;

    /**
     * 缓冲区
     */
    private Deque<T> buffer;

    /**
     * 缓冲区锁/写锁
     */
    private final Semaphore bufferMutex;

    /**
     * 读线程数量
     */
    private int peekCount;

    /**
     * 读锁
     */
    private final Object peekLock;

    public ConcurrentStack(int maxSize) {
        this.pushSemaphore = new Semaphore(maxSize);
        this.popSemaphore = new Semaphore(0);
        this.buffer = new LinkedList<>();
        this.bufferMutex = new Semaphore(1);
        this.peekCount = 0;
        this.peekLock = new Object();
    }

    public void push(T e) throws InterruptedException {
        // 缓冲区满则阻塞
        pushSemaphore.acquire();
        // 获得写锁
        bufferMutex.acquire();

        // push
        buffer.push(e);

        // 释放写锁
        bufferMutex.release();
        // 消费者信号量 V 操作
        popSemaphore.release();
    }

    public T pop() throws InterruptedException {
        T ret = null;
        // 缓冲区空则阻塞
        popSemaphore.acquire();
        // 获得写锁
        bufferMutex.acquire();

        // pop
        ret = buffer.pop();

        // 释放写锁
        bufferMutex.release();
        // 生产者信号量 P 操作
        pushSemaphore.release();

        return ret;
    }

    public T peek() throws InterruptedException {
        T ret = null;

        // 第一个读线程需要获取缓冲区锁
        synchronized (peekLock) {
            if (++peekCount == 1) {
                bufferMutex.acquire();
            }
        }

        // peek
        ret = buffer.peek();

        // 最后一个读线程需要释放缓冲区锁
        synchronized (peekLock) {
            if (--peekCount == 0) {
                bufferMutex.release();
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        ConcurrentStack<Integer> concurrentStack = new ConcurrentStack<>(20);
        int pushNum = 10, popNum = 10, peekNum = 10;
        while (pushNum-- > 0) {
            new Thread(() -> {
                Random random = new Random();
                while (true) {
                    try {
                        Thread.sleep(random.nextInt(3));
                        concurrentStack.push(random.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        while (popNum-- > 0) {
            new Thread(() -> {
                Random random = new Random();
                while (true) {
                    try {
                        Thread.sleep(random.nextInt(3));
                        System.out.println("pop: " + concurrentStack.pop());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        while (peekNum-- > 0) {
            new Thread(() -> {
                Random random = new Random();
                while (true) {
                    try {
                        Thread.sleep(random.nextInt(3));
                        System.out.println("peek:" + concurrentStack.peek());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
