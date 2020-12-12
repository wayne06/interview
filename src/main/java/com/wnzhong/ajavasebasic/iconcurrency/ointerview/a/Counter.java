package com.wnzhong.ajavasebasic.iconcurrency.ointerview.a;

/**
 * @author wayne
 */
public class Counter {

    private volatile int count = 0;

    public void inc() {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    @Override
    public String toString() {
        return "count=" + count;
    }

}
