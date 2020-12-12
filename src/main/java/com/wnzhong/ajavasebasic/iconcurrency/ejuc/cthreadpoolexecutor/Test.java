package com.wnzhong.ajavasebasic.iconcurrency.ejuc.cthreadpoolexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * corePoolSize - 池中所保存的线程数，包括空闲线程。
 * maximumPoolSize - 池中允许的最大线程数。
 * keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
 * unit - keepAliveTime 参数的时间单位。
 * workQueue - 执行前用于保持任务的队列。此队列仅保持由 execute 方法提交的 Runnable 任务。
 *
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {

        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveTime = 5000;

        ExecutorService executorService =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>()
                );
    }

}
