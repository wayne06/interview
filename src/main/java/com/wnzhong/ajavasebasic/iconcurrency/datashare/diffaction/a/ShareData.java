package com.wnzhong.ajavasebasic.iconcurrency.datashare.diffaction.a;

/**
 * 共享数据类
 * @author wayne
 */
public class ShareData {

    private int num = 10;

    public synchronized void inc() {
        num++;
        System.out.println(Thread.currentThread().getName() + ": invoke inc method num = " + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void dec() {
        num--;
        System.out.println(Thread.currentThread().getName() + ": invoke dec method num = " + num);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
