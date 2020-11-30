package com.wnzhong.ajavasebasic.hcollection.dqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        ArrayList<String> tmpList = new ArrayList<>();

        // 向队列一添加元素
        queue1.offer("a");
        queue1.offer("b");
        queue1.offer("c");
        queue1.offer("d");
        queue1.offer("e");
        System.out.print("进栈： ");

        // 队列一的元素一次加入 list 集合中
        for (String s : queue1) {
            tmpList.add(s);
            System.out.print(s);
        }

        // 以倒序的方法取出 list 集合中的值，加入队列二
        //Collections.reverse(tmpList);
        //for (String s : tmpList) {
        //    queue2.offer(s);
        //}
        for (int i = tmpList.size() - 1; i >= 0; i--) {
            queue2.offer(tmpList.get(i));
        }

        // 打印出栈队列
        System.out.println("");
        System.out.print("出栈： ");
        for (String q : queue2) {
            System.out.print(q);
        }
    }

}
