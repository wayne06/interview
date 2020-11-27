package com.wnzhong.ajavasebasic.bgrammer.bhashcode;

import java.util.Objects;

/**
 * @author wayne
 */
public class UserB {

    private int id;
    private String name;
    private int age;

    public UserB() {
    }

    public UserB(int id, String name, int age) {
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
     * 如果不重写 equals 方法，执行 user1.equals(user2) 比较的就是两个对象的地址（即 user1 == user2），肯定是不相等的
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

        if (o instanceof UserB) {
            UserB other = (UserB) o;
            if (this.age != other.age) {
                return false;
            }
            //return this.name != null ? this.name.equals(other.name) : other.name == null;
            return Objects.equals(this.name, other.name);

        }
        return false;
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
