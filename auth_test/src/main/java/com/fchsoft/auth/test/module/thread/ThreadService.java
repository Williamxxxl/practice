package com.fchsoft.auth.test.module.thread;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName ThreadService.java
 * @Description
 * @createTime 2022-01-19 13:44
 */
@Service
public class ThreadService {
    int sum = 1;
    volatile boolean hasEggs = false;

    int ticketSum = 100;

    public void getThread() {
        ExecutorService et = Executors.newFixedThreadPool(2);
        et.execute(() -> {
            while (true) {
                if (!hasEggs) {
                    synchronized (this) {
                        try {
                            System.out.println("等待收获");
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    System.out.println("累计收获了" + sum + "个鸡蛋");
                    sum++;
                    hasEggs = false;
                }
            }
        });

        et.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                    System.out.println("下蛋了");
                    hasEggs = true;
                    synchronized (this){
                        this.notify(); //为了调用wait()和notify(),线程必须先获得那个对象的锁(synchronized)
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
