package com.wnzhong.ajavasebasic.dexception;

/**
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(test());
    }

    private static int test() {
        try {
            int a = 1 / 0;
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            return 3;
        }
    }


}
