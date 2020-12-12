package com.wnzhong.ajavasebasic.iconcurrency.ointerview.b;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wayne
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("---- Program start ----");
        Date date1 = new Date();
        int taskSize = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(taskSize);
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable callable = new MyCallable(i + " ");
            Future future = executorService.submit(callable);
            futures.add(future);
        }
        executorService.shutdown();
        for (Future f : futures) {
            System.out.println(">>> " + f.get().toString());
        }
        Date date2 = new Date();
        System.out.println("---- Program stop ----");
        System.out.println("Program cost [" + (date2.getTime() - date1.getTime()) + "ms]");
    }

    static class MyCallable implements Callable {
        private String taskNum;

        public MyCallable(String taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public Object call() throws Exception {
            System.out.println(">>> task " + taskNum + " start");
            Date dateTmp1 = new Date();
            Thread.sleep(1000);
            Date dateTmp2 = new Date();
            long time = dateTmp2.getTime() - dateTmp1.getTime();
            System.out.println(">>> task " + taskNum + " stop");
            return "Task " + taskNum + " return result, cost [" + time + "ms]";
        }
    }
}
