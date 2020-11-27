package com.wnzhong.ajavasebasic.bgrammer.cstring;

import java.util.Random;

/**
 * @author wayne
 */
public class TestComplexPlus {

    public static void main(String[] args) {
        String s = "";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            s = s + random.nextInt(1000) + " ";
        }
        System.out.println(s);
    }

}
