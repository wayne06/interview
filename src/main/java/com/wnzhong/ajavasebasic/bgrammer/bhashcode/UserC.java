package com.wnzhong.ajavasebasic.bgrammer.bhashcode;

import java.util.Objects;

/**
 * @author wayne
 */
public class UserC {

    private int id;
    private String name;
    private int age;

    public UserC() {
    }

    public UserC(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 为什么要重写 equals 方法？
     * 如果不重写，执行 user1.equals(user2) 比较的就是两个对象的地址（即 user1 == user2），肯定是不相等的
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        if (o instanceof UserC) {
            UserC other = (UserC) o;
            if (this.age != other.age) {
                return false;
            }
            //return this.name != null ? this.name.equals(other.name) : other.name == null;
            return Objects.equals(this.name, other.name);

        }
        return false;
    }

    /**
     * 为什么要重写 hashcode 方法？
     * hashCode 是用于散列数据的快速存取，
     * 如利用 HashSet/HashMap/Hashtable 类来存储数据时，都会根据存储对象的 hashCode 值来进行判断是否相同的。
     * @return
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;

        //int result = 17;
        //result = 31 * result + (name == null ? 0 : name.hashCode());
        //result = 31 * result + (age == null ? 0 : age.hashCode());
        //return result;
    }

    @Override
    public String toString() {
        return "UserA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
