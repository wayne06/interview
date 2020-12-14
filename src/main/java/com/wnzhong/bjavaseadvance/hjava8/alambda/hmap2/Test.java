package com.wnzhong.bjavaseadvance.hjava8.alambda.hmap2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7s = G7.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(G7s);
    }

}
