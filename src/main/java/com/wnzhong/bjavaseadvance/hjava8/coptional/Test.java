package com.wnzhong.bjavaseadvance.hjava8.coptional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Optional类：
 * 一个可以为 null 的容器对象。如果值存在则 isPresent()方法会返回 true。
 * 调用 get()方法会返回该对象。
 *
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {
        // Optional.of()
        // 为非 null 的值创建一个 Optional 对象
        // of 方法通过工厂方法创建 Optional 类
        // 创建对象时传入的参数不能为 null。如果传入参数为 null，则抛出 NullPointerException
        Optional<String> a = Optional.of("a");
        //Optional<String> someNull1 = Optional.of(null);

        // Optional.ofNullable()
        // 为指定的值创建一个 Optional，如果指定值为 null，则返回一个空的 Optional
        // ofNullable 与 of 方法相似，唯一区别是可以接受参数为 null
        Optional empty1 = Optional.ofNullable(null);

        // Optional.isPresent()
        // 判断预期值是否存在，存在返回 true，不存在返回 false
        Optional<String> b = Optional.of("b");
        if (b.isPresent()) {
            System.out.println(b.get());
        }

        // Optional.get()
        // 如果 Optional 有值则将其返回，否则抛出 NoSuchElementException
        try {
            Optional empty2 = Optional.ofNullable(null);
            System.out.println(empty2.get());
        } catch (NoSuchElementException ex) {
            System.out.println(ex.toString());
        }

        // ifPresent()
        // 如果 Optional 实例有值则为其调用 consumer，否则不做处理
        // Consumer 类包含一个抽象方法。该抽象方法对传入的值进行处理，但没有返回值。
        // Java8 支持不用接口直接通过 lambda 表达式传入参数，如果 Optional实例有值，调用 ifPresent()可以接受接口段或 lambda 表达式
        Optional<String> c = Optional.of("c");
        c.ifPresent(value -> System.out.println("Length of value : " + value.length()));

        // orElse()
        // 如果 Optional 实例有值则将其返回，否则返回 orElse 方法传入的参数。
        Optional<String> d = Optional.of("d");
        Optional<String> someNull2 = Optional.ofNullable(null);
        System.out.println(someNull2.orElse("There is no value present."));
        System.out.println(d.orElse("There is value."));

        // orElseGet()
        // orElseGet 与 orElse 方法类似，区别在于得到的默认值。
        // orElse 方法将传入的字符串作为默认值， orElseGet方法可以接受 Supplier 接口的实现用来生成默认值
        Optional<String> e = Optional.of("e");
        Optional<String> someNull3 = Optional.ofNullable(null);
        System.out.println(someNull3.orElseGet(() -> "Default value."));
        System.out.println(e.orElseGet(() -> "Default value."));

        // orElseThrow()
        // 如果有值则将其返回，否则抛出 supplier 接口创建的异常
        // 在 orElseGet 方法中，我们传入一个 Supplier 接口。
        // 然而，在 orElseThrow 中我们可以传入一个 lambda 表达式或方法，如果值不存在来抛出异常
        try {
            Optional<String> empty3 = Optional.of(null);
            empty3.orElseThrow(ValueAbsentException::new);
        } catch (Throwable th) {
            System.out.println(th.toString());
        }

        try {
            Optional<String> empty4 = Optional.ofNullable(null);
            empty4.orElseThrow(ValueAbsentException::new);
        } catch (Throwable th) {
            System.out.println(th.toString());
        }

        // map()
        // 如果有值，则对其执行调用 mapping 函数得到返回值。
        // 如果返回值不为 null，则创建包含 mapping 返回值的 Optional 作为 map 方法返回值，否则返回空 Optional
        // map 方法用来对 Optional 实例的值执行一系列操作。通过一组实现了 Function 接口的 lambda 表达式传入操作
        Optional<String> f = Optional.of("f");
        Optional<String> upperF = f.map(value -> value.toUpperCase());
        System.out.println(upperF.orElse("No value found."));

        // flatMap()
        // 如果有值，为其执行 mapping 函数返回 Optional 类型返回值，否则返回空 Optional。
        // flatMap 与 map 方法类似，区别在于 flatMap 中的 mapper 返回值必须是 Optional。
        // 调用结束时， flatMap 不会对结果用 Optional 封装
        Optional<String> g = Optional.of("g");
        Optional<String> upperG = g.flatMap(value -> Optional.of(value.toUpperCase()));
        System.out.println(upperG.orElse("No value found."));

        // filter()
        // 如果有值并且满足断言条件，返回包含该值的 Optional，否则返回空 Optional
        // filter 个方法通过传入限定条件对 Optional 实例的值进行过滤。
        // 这里可以传入一个 lambda 表达式。对于filter 函数我们应该传入实现了 Predicate 接口的 lambda 表达式
        Optional<String> h = Optional.of("hhhhhhh");
        Optional<String> longH = h.filter(value -> value.length() > 6);
        System.out.println(longH.orElse("h is less than 6 characters"));

        Optional<String> i = Optional.of("i");
        Optional<String> shortI = i.filter(value -> value.length() > 6);
        System.out.println(shortI.orElse("i is less than 6 characters"));
    }

    static class ValueAbsentException extends Throwable {
        public ValueAbsentException() {
            super();
        }

        public ValueAbsentException(String msg) {
            super(msg);
        }

        @Override
        public String getMessage() {
            return "No value present in the Optional instance.";
        }
    }

}
