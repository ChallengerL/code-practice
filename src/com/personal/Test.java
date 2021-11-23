package com.personal;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description: 生产者消费者
 * @author: liuXiaoHan
 * @date: 2021-09-08 16:44
 **/
public class Test {
    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args)  {
        Test test = new Test();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread{

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while(true){
                try {
                    queue.take();
//                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
                    System.out.println("消费者消费第"+(queue.size()+1)+"个产品");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread{

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while(true){
                try {
                    queue.put(1);
//                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
                    System.out.println("生产者生产第"+queue.size()+"个产品");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
