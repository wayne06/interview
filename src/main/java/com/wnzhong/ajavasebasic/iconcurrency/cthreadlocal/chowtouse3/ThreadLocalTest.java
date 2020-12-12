package com.wnzhong.ajavasebasic.iconcurrency.cthreadlocal.chowtouse3;

import java.util.Random;

/**
 * ThreadLocal 的使用方式3：在线程类内部创建 ThreadLocal
 *
 * 1、在多线程的类（如 ThreadDemo 类）中，创建一个 ThreadLocal 对象 threadXxx，用来保存线程间需要隔离处理的对象 xxx。
 * 2、在 ThreadDemo 类中，创建一个获取要隔离访问的数据的方法 getXxx()，在方法中判断，若 ThreadLocal 对象为 null 时候，
 *    应该 new()一个隔离访问类型的对象，并强制转换为要应用的类型
 * 3、在 ThreadDemo 类的 run()方法中，通过调用 getXxx()方法获取要操作的数据，这样可以保证每个线程对应一个数据对象，
 *    在任何时刻都操作的是这个对象
 *
 * @author wayne
 */
public class ThreadLocalTest implements Runnable {

    ThreadLocal<Student> studentThreadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running..");



        // 为每个线程独立 new 一个 student 对象，每个线程的 student 对象都可以设置不同的值
        Student student = getStudent();
        Random random = new Random();
        int age = random.nextInt(100);
        student.setAge(age);
        System.out.println(currentThreadName + " is set age: " + age);
        System.out.println(currentThreadName + " is first get age: " + student.getAge());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThreadName + " is second get age: " + student.getAge());
    }

    private Student getStudent() {
        Student student = studentThreadLocal.get();
        if (student == null) {
            student = new Student();
            studentThreadLocal.set(student);
        }
        return student;
    }

    class Student {
        int age;
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        ThreadLocalTest t = new ThreadLocalTest();
        Thread t1 = new Thread(t, "Thread A");
        Thread t2 = new Thread(t, "Thread B");
        t1.start();
        t2.start();
    }
}
