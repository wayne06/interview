package com.wnzhong.ajavasebasic.iconcurrency.ejuc.bexcutorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * execute(Runnable) 方法要求一个 java.lang.Runnable 对象，然后对它进行异步执行。
 *
 * 没有办法得知被执行的 Runnable 的执行结果。如果有需要的话你得使用一个 Callable
 *
 * @author wayne
 */
public class TestExecute {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> System.out.println("Asynchronous task."));
        executorService.shutdown();
    }


}
