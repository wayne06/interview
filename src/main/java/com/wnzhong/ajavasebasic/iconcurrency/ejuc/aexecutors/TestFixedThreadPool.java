package com.wnzhong.ajavasebasic.iconcurrency.ejuc.aexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定大小线程池
 *
 * Thread 类都是在线程池中运行的，线程池在执行 execute 方法来执行 Thread 类中的 run 方法。
 * 不管 execute 执行几次，线程池始终都会使用 2 个线程来处理。不会再去创建出其他线程来处理run 方法执行。这就是固定大小线程池。
 *
 * @author wayne
 */
public class TestFixedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
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
