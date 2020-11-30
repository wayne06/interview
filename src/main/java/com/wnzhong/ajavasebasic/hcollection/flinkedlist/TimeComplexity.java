package com.wnzhong.ajavasebasic.hcollection.flinkedlist;

import java.util.*;

/**
 * @author wayne
 */
public class TimeComplexity {

    public static final int N = 5000;
    public static List values;

    static {
        Integer[] vals = new Integer[N];
        Random random = new Random();
        for (int i = 0, currval = 0; i < N; i++) {
            vals[i] = new Integer(currval);
            currval += random.nextInt(100) + 1;
        }
        values = Arrays.asList(vals);
    }

    static long time(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            int index = Collections.binarySearch(list, values.get(i));
            if (index != i) {
                System.out.println("***错误***");
            }
        }
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        System.out.println("ArrayList 消耗时间： " + time(new ArrayList(values)));
        System.out.println("LinkedList 消耗时间： " + time(new LinkedList(values)));
    }


}
