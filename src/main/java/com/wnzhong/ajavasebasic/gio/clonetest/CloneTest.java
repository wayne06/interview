package com.wnzhong.ajavasebasic.gio.clonetest;

import java.io.IOException;

/**
 * 基于序列化和反序列化实现的克隆不仅仅是深度克隆，更重要的是通过泛型限定，可以检查出要克隆的对象是否支持序列化，
 * 这项检查是编译器完成的，不是在运行时抛出异常，这种是方案明显优于使用 Object 类的 clone方法克隆对象。
 * 让问题在编译的时候暴露出来总是好过把问题留到运行时。
 * @author wayne
 */
public class CloneTest {

    public static void main(String[] args) {
        try {
            Person person1 = new Person("Allen", 33, new Car("Benz", 300));
            Person person2 = MyUtil.clone(person1);
            System.out.println(person1);
            System.out.println(person2);

            person2.getCar().setBrand("BYD");
            System.out.println(person1);
            System.out.println(person2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
