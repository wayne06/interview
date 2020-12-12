package com.wnzhong.ajavasebasic.iconcurrency.ejuc.bexcutorservice;

import java.util.concurrent.*;

/**
 * submit(Callable) 方法类似于 submit(Runnable) 方法，除了它所要求的参数类型之外。
 * Callable 实例除了它的 call() 方法能够返回一个结果之外和一个 Runnable 很相像。
 * Runnable.run() 不能够返回一个结果。
 * Callable 的结果可以通过 submit(Callable) 方法返回的 Future 对象进行获取
 *
 * @author wayne
 */
public class TestCallableSubmit {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future future = executorService.submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                System.out.println("Asynchronous callable.");
                return "Callable result";
            }
        });

        System.out.println(future.get());
        executorService.shutdown();
    }

}
