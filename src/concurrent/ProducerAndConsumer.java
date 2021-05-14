package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


//public class ProducerAndConsumer {
//
//    List<Object> buffer;
//
//    Semaphore producerSemaphore;
//
//    Semaphore consumerSemaphore;
//
//    final Object bufferLock;
//
//    class Semaphore {
//        int n;
//
//        Semaphore(int n) {
//            this.n = n;
//        }
//
//        // P 操作
//        synchronized void down() {
//            try {
//                while (n == 0) {
//                    this.wait();
//                }
//                --n;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // V 操作
//        synchronized void up() {
//            ++n;
//            this.notifyAll();
//        }
//    }
//
//    public ProducerAndConsumer(int n) {
//        buffer = new ArrayList<>();
//        producerSemaphore = new Semaphore(n);
//        consumerSemaphore = new Semaphore(0);
//        bufferLock = new Object();
//    }
//
//    class Producer extends Thread {
//        @Override
//        public void run() {
//            while (true) {
//                producerSemaphore.down();
//                synchronized (bufferLock) {
//                    String tmp = Thread.currentThread().getName();
//                    buffer.add(tmp);
//                    System.out.println("Producer " + tmp + ": new product");
//                }
//                // 确保缓冲区里已经放入了生产的元素后再更新消费者信号量
//                consumerSemaphore.up();
//            }
//        }
//    }
//
//    class Consumer extends Thread {
//
//        @Override
//        public void run() {
//            while (true) {
//                consumerSemaphore.down();
//                synchronized (bufferLock) {
//                    Object o = buffer.remove(buffer.size() - 1);
//                    System.out.println("Consumer " + Thread.currentThread() + ":" + o);
//                }
//                producerSemaphore.up();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer(20);
//        int producerNum = 5, consumerNum = 10;
//        while (producerNum-- > 0) {
//            producerAndConsumer.new Producer().start();
//        }
//
//        while (consumerNum-- > 0) {
//            producerAndConsumer.new Consumer().start();
//        }
//
//        Thread record = new Thread(() -> {
//            while (true)
//                System.out.println(producerAndConsumer.buffer.size());
//        });
//        record.setDaemon(true);
//        record.run();
//    }
//}

class ProducerAndConsumer {

    public static void main(String[] args) {
        BlockingQueue buffer = new ArrayBlockingQueue(20);
        int producerNum = 10, consumerNum = 10;
        while (producerNum-- > 0) {
            new Thread(() -> {
                while (true) {
                    String tmp = Thread.currentThread().getName();
                    try {
                        buffer.put(tmp);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Producer " + tmp + ": new product");
                }
            }).start();
        }

        while (consumerNum-- > 0) {
            new Thread(() -> {
                while (true) {
                    Object o = null;
                    try {
                        o = buffer.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Consumer " + Thread.currentThread() + ":" + o);
                }
            }).start();
        }

        Thread record = new Thread(() -> {
            while (true)
                System.out.println(buffer.size());
        });
        record.setPriority(10);
        record.setDaemon(true);
        record.run();
    }
}