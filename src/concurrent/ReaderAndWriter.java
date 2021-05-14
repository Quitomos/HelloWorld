package concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//public class ReaderAndWriter {
//
//    int readerNum;
//
//    final Object readerNumLock;
//
//    final Semaphore mutex;
//
//    ReaderAndWriter() {
//        this.readerNum = 0;
//        this.readerNumLock = new Object();
//        this.mutex = new Semaphore(1);
//    }
//
//    class Reader extends Thread {
//
//        @Override
//        public void run() {
//            // 第一位读者加锁
//            synchronized (readerNumLock) {
//                if (++readerNum == 1) {
//                    // 这里应在读锁内完成，防止后来的读锁直接跨过写锁来读
//                    try {
//                        mutex.acquire();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            // 读
//            System.out.println("Reading...");
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Finish Reading.");
//
//            // 最后一位读者解锁
//            synchronized (readerNumLock) {
//                if (--readerNum == 0) {
//                    mutex.release();
//                }
//            }
//        }
//    }
//
//    class Writer extends Thread {
//        @Override
//        public void run() {
//            // 所有写者都需要获取互斥锁
//            try {
//                mutex.acquire();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            // 写
//            System.out.println("Writing...");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println();
//            System.out.println("Finish Writing.");
//
//            mutex.release();
//        }
//    }
//
//    public static void main(String[] args) {
//        ReaderAndWriter readerAndWriter = new ReaderAndWriter();
//        int readerNum = 30, writerNum = 3;
//        while (readerNum-- > 0 | writerNum-- > 0) {
//            if (writerNum >= 0)
//                readerAndWriter.new Writer().start();
//            if (readerNum >= 0)
//                readerAndWriter.new Reader().start();
//        }
//
//
//
//        Thread record = new Thread(() -> {
//            while (true) {
//                System.out.println(readerAndWriter.readerNum);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        record.setDaemon(true);
//        record.start();
//    }
//}

public class ReaderAndWriter {

    final ReadWriteLock readWriteLock;

    ReaderAndWriter() {
        this.readWriteLock = new ReentrantReadWriteLock();
    }

    class Reader extends Thread {
        @Override
        public void run() {
            readWriteLock.readLock().lock();

            // 读
            System.out.println("Reading...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finish Reading.");

            readWriteLock.readLock().unlock();
        }
    }

    class Writer extends Thread {
        @Override
        public void run() {
            readWriteLock.writeLock().lock();

            // 写
            System.out.println("Writing...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println("Finish Writing.");

            readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReaderAndWriter readerAndWriter = new ReaderAndWriter();
        int readerNum = 30, writerNum = 3;
        while (readerNum-- > 0 | writerNum-- > 0) {
            if (readerNum >= 0)
                readerAndWriter.new Reader().start();
            if (writerNum >= 0)
                readerAndWriter.new Writer().start();
        }
    }
}