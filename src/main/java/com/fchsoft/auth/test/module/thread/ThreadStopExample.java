package com.fchsoft.auth.test.module.thread;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName ThreadStopExample.java
 * @Description
 * @createTime 2022-01-19 13:55
 */
public class ThreadStopExample implements Runnable { //通过集成Thread创建自定义的线程类

    private boolean flag = true;

    public void stopThread() {
        flag = false;
    }

    public void run() {
        while (flag) {
            try {
                Thread.sleep(1000 * 60 * 60);
            } catch (InterruptedException e) {
                System.out.println("线程被中断!");
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("线程启动!");
        ThreadStopExample tse = new ThreadStopExample();
        Thread thread = new Thread(tse);
        thread.setPriority(Thread.MIN_PRIORITY);//线程优先级
        thread.setDaemon(true);
        thread.start();
        //thread.interrupt();//中断阻塞的线程,抛出线程打断InterruptedException异常
        //tse.stopThread();
    }

}
