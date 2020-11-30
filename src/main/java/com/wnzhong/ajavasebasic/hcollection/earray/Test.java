package com.wnzhong.ajavasebasic.hcollection.earray;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 4, 2, 5, 4, 5, 8, 7, 8, 77, 88, 5, 4, 9, 6, 2, 4, 1, 5};
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr) {
            map.put(i, map.get(i) == null ? 1 : map.get(i) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "出现： " + entry.getValue() + "次");
        }
    }

}
