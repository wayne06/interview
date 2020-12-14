package com.wnzhong.bjavaseadvance.hjava8.blambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author wayne
 */
public class Test1 {

    public static void main(String[] args) {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7);
        int factor = 2;

        // lambda 表达式有个限制，那就是只能引用 final 或 final 局部变量，这就是说不能在 lambda 内部修改定义在域外的变量
        //primes.forEach(element -> factor++);

        // 只是访问它而不作修改是可以的
        primes.forEach(element -> System.out.println(factor * element));
    }

}
