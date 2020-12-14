package com.wnzhong.bjavaseadvance.hjava8.alambda.dpredicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J : ");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.println("Languages which ends with a : ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("All languages : ");
        filter(languages, (str) -> true);

        System.out.println("Nothing : ");
        filter(languages, (str) -> false);

        System.out.println("Languages which length greater than 4 : ");
        filter(languages, str -> str.length() > 4);
    }

    public static void filter(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    public static void filter1(List<String> names, Predicate<String> condition) {
        names.stream()
                .filter(name -> (condition.test(name)))
                .forEach(name -> System.out.println(name + " "));
    }


}
