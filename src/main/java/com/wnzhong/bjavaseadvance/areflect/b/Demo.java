package com.wnzhong.bjavaseadvance.areflect.b;

/**
 * 每一个类都是Class类的实例对象，这个实例对象(该类的类类型)有三种表示方法
 *
 * @author wayne
 */
public class Demo {

    public static void main(String[] args) {
        Lei duixiang1 = new Lei();

        Class<?> c1 = Lei.class;
        Class<?> c2 = duixiang1.getClass();
        Class<?> c3 = null;
        try {
            c3 = Class.forName("com.wnzhong.bjavaseadvance.areflect.b.Lei");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("c1 == c2 ? " + (c1 == c2));
        System.out.println("c2 == c3 ? " + (c2 == c3));

        try {
            Lei duixiang2 = (Lei) c1.newInstance();
            duixiang2.print();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}
