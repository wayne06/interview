package com.wnzhong.ajavasebasic.bgrammer.cstring;

import java.util.Random;

/**
 * @author wayne
 */
public class TestStringBuilder {

    public static void main(String[] args) {
        String s = "";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(random.nextInt(1000));
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString());
    }

}
