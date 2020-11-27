package com.wnzhong.ajavasebasic.hcollection.asort;

import java.util.*;

/**
 * @author wayne
 */
public class SortTest {

    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, new User("alex", 11));
        userMap.put(2, new User("bob", 12));
        userMap.put(3, new User("crystal", 10));
        userMap.put(4, new User("doug", 13));
        userMap.put(5, new User("ellen", 9));
        userMap.put(6, new User("frank", 14));
        userMap.put(7, new User("green", 8));

        Map<Integer, User> sortedMap = sort(userMap);
        System.out.println(sortedMap);
    }

    private static Map<Integer, User> sort(Map<Integer, User> userMap) {
        // 1.拿到 map 的键值对集合
        Set<Map.Entry<Integer, User>> entrySet = userMap.entrySet();

        // 2.将 set 集合转换为 List 集合，目的是为了使用工具类的排序方法
        List<Map.Entry<Integer, User>> entryList = new ArrayList<>(entrySet);

        // 3.使用 Collections 集合工具类对 list 进行排序，排序规则使用匿名内部类或 lambda 表达式
        Collections.sort(
                entryList,
                (o1, o2) -> o2.getValue().getAge() - o1.getValue().getAge());

        // 4.创建有序的 HashMap 的集合，即 LinkedHashMap
        HashMap<Integer, User> result = new LinkedHashMap<>();

        // 5.将 list 中的数据存储到 linkedHashMap 中
        for (Map.Entry<Integer, User> entry : entryList) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }


}
