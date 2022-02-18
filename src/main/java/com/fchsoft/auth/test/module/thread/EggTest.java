package com.fchsoft.auth.test.module.thread;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName EggTest.java
 * @Description
 * @createTime 2022-01-19 14:57
 */
public class EggTest {
    int sum = 1;
    volatile boolean hasEggs = false;
    Object flag = new Object();
    Thread human = new Thread(() -> {
        while (true) {
            if (!hasEggs){
                synchronized (flag){
                    try {
                        System.out.println("等待收获");
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("累计收获了"+sum+"个鸡蛋");
                sum++;
                hasEggs = false;
            }
        }
    });

    Thread hen = new Thread(() -> {
       while (true) {
           try {
               Thread.sleep(3000);
               System.out.println("下蛋了");
               hasEggs = true;
               synchronized (flag){
                   flag.notify(); //为了调用wait()和notify(),线程必须先获得那个对象的锁(synchronized)
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    });

    public static void main(String[] args) {
        EggTest et = new EggTest();
        et.human.start();
        et.hen.start();
    }
}
