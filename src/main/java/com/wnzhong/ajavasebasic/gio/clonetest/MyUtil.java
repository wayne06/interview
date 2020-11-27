package com.wnzhong.ajavasebasic.gio.clonetest;

import java.io.*;

/**
 * 通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆
 * @author wayne
 */
public class MyUtil {

    public static <T extends Serializable> T clone(T obj) throws IOException, ClassNotFoundException {
        // 说明：调用 ByteArrayInputStream 或 ByteArrayOutputStream 对象的 close 方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        return (T) objectInputStream.readObject();
    }

}
