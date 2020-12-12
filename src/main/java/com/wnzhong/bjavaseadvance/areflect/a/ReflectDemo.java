package com.wnzhong.bjavaseadvance.areflect.a;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wayne
 */
public class ReflectDemo {

    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchFieldException {
        Class robotClass = Class.forName("com.wnzhong.bjavaseadvance.areflect.a.Robot");
        System.out.println("robotClass.getName() - " + robotClass.getName());

        Method throwHello = robotClass.getDeclaredMethod("throwHello", String.class);
        throwHello.setAccessible(true);

        Robot robot = (Robot) robotClass.newInstance();

        Object obj = throwHello.invoke(robot, "bob");
        System.out.println(obj);

        Method sayHi = robotClass.getMethod("sayHi", String.class);
        sayHi.invoke(robot, "welcome");

        Field name = robotClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(robot, "alice");
        sayHi.invoke(robot, "welcome");
    }

}
