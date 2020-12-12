package com.wnzhong.ajavasebasic.iconcurrency.datashare.diffaction.b;

public class Test {

    /**
     * 多个线程行为不一致共同操作一个数据：
     *
     * 将这些 Runnable 对象作为某一个类中的内部类，共享数据作为这个外部类中的成员变量，每个线程对
     * 共享数据的操作方法也分配给外部类，以便实现对共享数据进行的各个操作的互斥和通信，作为内部类的各个
     * Runnable 对象调用外部类的这些方法
     *
     * @param args
     */
    public static void main(String[] args) {
        final ShareData shareData = new ShareData();
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                new Thread(() -> {
                    for (int j = 0; j < 5; j++) {
                        shareData.inc();
                    }
                }, "Thread " + i).start();
            } else {
                new Thread(() -> {
                    for (int j = 0; j < 5; j++) {
                        shareData.dec();
                    }
                }, "Thread " + i).start();
            }
        }

    }

}
