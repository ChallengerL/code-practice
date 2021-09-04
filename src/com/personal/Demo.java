package com.personal;

/**
 * @author liuxiaohan1
 * @date 2021-09-01 4:29 下午
 */
public class Demo {

    public static Object lock = new Object();
    private static volatile int signal = 0;

    public static class ThreadA implements Runnable {

        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 0) {
                    System.out.println("A" + signal);
                    signal++;
                }
            }


//            synchronized (lock) {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("A");
//                    lock.notify();
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
////                lock.notify();
//            }
        }
    }

    public static class ThreadB implements Runnable {

        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 1) {
                    System.out.println("B" + signal);
                    signal++;
                }
            }
//            synchronized (lock) {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("B");
//                    lock.notify();
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
////                lock.notify();
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(10);
        new Thread(new ThreadB()).start();
    }

}
