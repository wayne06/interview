package com.wnzhong.ajavasebasic.iconcurrency.ejuc.aexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单任务线程池
 *
 * 在 java 的多线程中，一但线程关闭，就会成为死线程。关闭后死线程就没有办法在启动了。再次启动就会出现异常信息：
 * Exception in thread "main" java.lang.IllegalThreadStateException。如何解决这个问题：
 *
 * 使用 Executors.newSingleThreadExecutor()来再次启动一个线程。
 *
 * @author wayne
 */
public class TestSingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
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
