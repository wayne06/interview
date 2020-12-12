package com.wnzhong.bjavaseadvance.areflect.a;

/**
 * @author wayne
 */
public class Robot {

    private String name;

    static {
        System.out.println("this is in static block");
    }

    public void sayHi(String s) {
        System.out.println(s + " - " + name);
    }

    private String throwHello(String tag) {
        return "hello " + tag;
    }

}
