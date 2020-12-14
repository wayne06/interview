package com.wnzhong.bjavaseadvance.hjava8.alambda.arunnable;

/**
 * (params) -> expression
 * (params) -> statement
 * (params) -> { statement }
 *
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("before Java8");
            }
        }).start();

        new Thread(() -> System.out.println("lambda expression")).start();
    }

}
