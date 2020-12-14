package com.wnzhong.bjavaseadvance.hjava8.alambda.gfilter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "bcd", "defg", "jk");
        List<String> filtered = strings.stream()
                .filter(x -> x.length() > 2)
                .collect(Collectors.toList());
        System.out.println("Original list : " + strings);
        System.out.println("Filtered list : " + filtered);
    }

}
