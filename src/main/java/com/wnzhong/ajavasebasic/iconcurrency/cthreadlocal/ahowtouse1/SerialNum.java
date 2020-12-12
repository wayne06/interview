package com.wnzhong.ajavasebasic.iconcurrency.cthreadlocal.ahowtouse1;

/**
 * ThreadLocal 的使用方式1：在关联数据类中创建 private static ThreadLocal
 *
 * 在下面的类中，私有静态 ThreadLocal 实例（serialNum）为调用该类的静态 SerialNum.get() 方法的每个线程维护了一个“序列号”，
 * 该方法将返回当前线程的序列号。（线程的序列号是在第一次调用 SerialNum.get() 时分配的，并在后续调用中不会更改。）
 *
 * @author wayne
 */
public class SerialNum {

    /**
     * the next serial number to be assigned
     */
    private static int nextSerialNum = 0;

    private static ThreadLocal serialNum = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return nextSerialNum++;
        }
    };

    //private static ThreadLocal serialNum = ThreadLocal.withInitial(() -> nextSerialNum++);

    public static int get() {
        return (Integer) (serialNum.get());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(SerialNum.get());
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(SerialNum.get());
            }).start();
        }
        System.out.println(SerialNum.get());

    }

}
