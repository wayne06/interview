package com.wnzhong.bjavaseadvance.hjava8.alambda.cforeach;

import java.util.Arrays;
import java.util.List;

/**
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {

        List<String> features = Arrays.asList("lambda", "default", "stream", "date");

        for (String feature : features) {
            System.out.println(feature);
        }

        features.forEach(n -> System.out.println(n));

        // method reference
        features.forEach(System.out::println);

    }

}
