package com.wnzhong.ajavasebasic.hcollection.cmap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author wayne
 */
public class Test1 {

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> hashTable = new Hashtable<>();

        hashMap.put(null, null);
        System.out.println("hashMap 的[key]和[value]均可以为 null:" + hashMap.get(null));

        try {
            hashTable.put(null, "3");
            System.out.println(hashTable.get(null));
        } catch (Exception e) {
            System.out.println("【ERROR】： hashTable 的[key]不能为 null");
        }

        try {
            hashTable.put("3", null);
            System.out.println(hashTable.get("3"));
        } catch (Exception e) {
            System.out.println("【ERROR】： hashTable 的[value]不能为 null");
        }
    }

}
