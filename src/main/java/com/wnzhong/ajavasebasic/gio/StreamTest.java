package com.wnzhong.ajavasebasic.gio;

import java.io.*;

/**
 * @author wayne
 */
public class StreamTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(new File("D://obj")));
        objectOutputStream.writeObject(new User("alex", 100));
        objectOutputStream.close();

        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(new File("D://obj")));
        User user = (User) objectInputStream.readObject();
        System.out.println(user);
        objectInputStream.close();
    }

}
