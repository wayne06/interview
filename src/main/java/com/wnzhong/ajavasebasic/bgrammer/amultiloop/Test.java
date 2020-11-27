package com.wnzhong.ajavasebasic.bgrammer.amultiloop;

import java.util.concurrent.ForkJoinPool;

/**
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(j);
                if (j == 1) {
                    break;
                }
            }
        }
        System.out.println("Over1");

        labelA:
        for (int i = 0; i < 3; i++) {
            labelB:
            for (int j = 0; j < 3; j++) {
                System.out.println(j);
                if (j == 1) {
                    break labelA;
                }
            }
        }
        System.out.println("Over2");
    }

}
