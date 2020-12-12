package com.wnzhong.ajavasebasic.iconcurrency.ejuc.bexcutorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * submit(Runnable) 方法也要求一个 Runnable 实现类，但它返回一个 Future 对象。这个 Future 对象可
 * 以用来检查 Runnable 是否已经执行完毕
 *
 * @author wayne
 */
public class TestSubmit {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future future = executorService.submit(() -> System.out.println("Asynchronous task."));

        //获得执行完 run 方法后的返回值，这里使用的 Runnable，所以这里没有返回值，返回的是 null
        System.out.println(future.get());

        executorService.shutdown();
    }


}
