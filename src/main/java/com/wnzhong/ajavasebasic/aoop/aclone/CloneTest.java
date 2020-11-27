package com.wnzhong.ajavasebasic.aoop.aclone;

/**
 * @author wayne
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p0 = new Person(23, "zhang");
        Person p1 = p0;
        Person p2 = (Person) p0.clone();
        System.out.println("p0=" + p0);
        System.out.println("p1=" + p1);
        System.out.println("p2=" + p2);
        System.out.println(p0.getName() == p2.getName() ? "clone is shallow copy." : "clone is deep copy.");
    }
}
