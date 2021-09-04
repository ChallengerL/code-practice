package com.personal;

/**
 * @author liuxiaohan1
 * @date 2021-08-26 2:52 下午
 */
public class DeadLock {

    public static void main(String[] args) {
        String resource1 = "resource1";
        String resource2 = "resource2";

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println("get resource:" + resource1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("try to get resource2");
                synchronized (resource2) {
                    System.out.println("get resource:" + resource2);
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println("get resource:" + resource2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("try to get resource1");
                synchronized (resource1) {
                    System.out.println("get resource:" + resource1);
                }
            }
        }, "B").start();
    }

}
