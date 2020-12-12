package com.wnzhong.ajavasebasic.iconcurrency.atimer;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author wayne
 */
public class MyTimerTask extends TimerTask {
    private static volatile int count = 1;

    @Override
    public void run() {
        System.err.println("Boob boom ");
        new Timer().schedule(new MyTimerTask(), 2000 + 2000 * count);
        count = (count + 1) % 2;
    }

    public static void main(String[] args) {
        new Timer().schedule(new MyTimerTask(), 2000);

        while (true) {
            System.out.println(Calendar.getInstance().get(Calendar.SECOND));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
