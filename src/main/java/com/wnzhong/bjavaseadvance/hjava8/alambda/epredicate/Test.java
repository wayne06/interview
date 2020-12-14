package com.wnzhong.bjavaseadvance.hjava8.alambda.epredicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        filter(languages);
    }

    public static void filter(List<String> names) {
        Predicate<String> startsWithJ = n -> n.startsWith("J");
        Predicate<String> fourLetterLong = n -> n.length() == 4;
        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach(n -> System.out.println("startsWithJ and fourLetterLong is : " + n ));
    }

}
