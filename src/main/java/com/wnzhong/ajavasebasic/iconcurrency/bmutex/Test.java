package com.wnzhong.ajavasebasic.iconcurrency.bmutex;

/**
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                business.subMethod();
            }
        }).start();
        for (int i = 0; i < 3; i++) {
            business.mainMethod();
        }
    }

    static class Business {
        private boolean flag = true;

        public synchronized void mainMethod() {
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + " : main thread running loop count --" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = true;
            notify();
        }

        public synchronized void subMethod() {
            while (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 4; i++) {
                System.err.println(Thread.currentThread().getName() + " : sub thread running loop count --" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = false;
            notify();
        }
    }

}
