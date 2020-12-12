package com.wnzhong.ajavasebasic.iconcurrency.datashare.diffaction.a;

public class Test {

    /**
     * 多个线程行为不一致共同操作一个数据：
     *
     * 将共享数据封装在另外一个对象中，然后将这个对象逐一传递给各个 Runnable 对象。每个线程对共享
     * 数据的操作方法也分配到那个对象身上去完成，这样容易实现针对该数据进行的各个操作的互斥和通信
     *
     * @param args
     */
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                new Thread(new RunnableCusToInc(shareData), "Thread " + i).start();
            } else {
                new Thread(new RunnableCusToDec(shareData), "Thread " + i).start();
            }
        }
    }

}
