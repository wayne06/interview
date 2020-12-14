package com.wnzhong.bjavaseadvance.hjava8.alambda.fmapreduce;

import java.util.Arrays;
import java.util.List;

/**
 * @author wayne
 */
public class Test2 {

    public static void main(String[] args) {

        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);

        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            total = total + price;
        }
        System.out.println("Total : " + total);

        double bill = costBeforeTax.stream()
                .map(cost -> cost + .12 * cost)
                .reduce((sum, cost) -> sum + cost)
                .get();
        System.out.println("Bill : " + bill);

    }

}
