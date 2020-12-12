package com.wnzhong.ajavasebasic.iconcurrency.ejuc.aexecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * 延迟线程池
 *
 * @author wayne
 */
public class TestScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);

        //使用定时执行风格的方法
        executorService.schedule(t4, 1, TimeUnit.SECONDS);
        executorService.schedule(t5, 1, TimeUnit.SECONDS);

        executorService.shutdown();

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "is running..");
        }
    }

}
