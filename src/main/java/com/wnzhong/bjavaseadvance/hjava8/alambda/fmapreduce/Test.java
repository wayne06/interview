package com.wnzhong.bjavaseadvance.hjava8.alambda.fmapreduce;

import java.util.Arrays;
import java.util.List;

/**
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);

        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
        }

        costBeforeTax.stream()
                .map(cost -> cost + .12 * cost)
                .forEach(System.out::println);
    }

}
