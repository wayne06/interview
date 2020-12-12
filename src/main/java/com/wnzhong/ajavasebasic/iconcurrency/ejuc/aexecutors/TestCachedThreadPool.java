package com.wnzhong.ajavasebasic.iconcurrency.ejuc.aexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可变线程池
 *
 * 可变任务线程池在执行 execute 方法来执行 Thread 类中的 run 方法。这里 execute 执行多次，
 * 线程池就会创建出多个线程来处理 Thread 类中 run 方法。所以会看到连接池会根据执行的情况，
 * 在程序运行时创建多个线程来处理，这里就是可变连接池的特点。
 *
 * @author wayne
 */
public class TestCachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
        executorService.execute(t5);

        executorService.shutdown();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running..");
        }
    }
}
