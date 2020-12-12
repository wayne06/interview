package com.wnzhong.ajavasebasic.iconcurrency.datashare.sameaction;

/**
 * 多个线程行为一致共同操作一个数据
 * @author wayne
 */
public class RunnableCusToInc implements Runnable {

    private ShareData shareData;

    public RunnableCusToInc(ShareData data) {
        this.shareData = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shareData.inc();
        }
    }

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 0; i < 4; i++) {
            new Thread(new RunnableCusToInc(shareData), "Thread " + i).start();
        }
    }
}
