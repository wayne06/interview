package com.wnzhong.ajavasebasic.fdatatype.aautounboxing;

/**
 * @author wayne
 */
public class AutoUnboxingTest {

    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;  // 将 3 自动装箱成 Integer 类型
        int c = 3;
        System.out.println(a == b);  // false  两个引用没有引用同一个对象
        System.out.println(a == c);  // true  a 自动拆箱成 int 类型，再和 c 比较
    }

}
