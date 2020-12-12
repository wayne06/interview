package com.wnzhong.ajavasebasic.iconcurrency.ointerview.a;

/**
 * @author wayne
 */
public class VolatileTest {

    public static void main(String[] args) {

        final Counter counter = new Counter();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.inc();
                }
            }).start();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);

    }

}
