package com.wnzhong.ajavasebasic.hcollection.flinkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wayne
 */
public class TimeComplexity2 {

    static long time(List list) {
        long start = System.currentTimeMillis();
        Object o = new Object();
        for (int i = 0; i < 50000; i++) {
            list.add(0, o);
        }
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        System.out.println(time(new ArrayList()));
        System.out.println(time(new LinkedList()));
    }

}
