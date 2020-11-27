package com.wnzhong.ajavasebasic.bgrammer.cstring;

/**
 * @author wayne
 */
public class TestString {

    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = "aaa";
        String s3 = new String("aaa");
        String s4 = new String("aaa");

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);

        s2 = new String("aaa");
        System.out.println(s2 == s1);
    }
}
