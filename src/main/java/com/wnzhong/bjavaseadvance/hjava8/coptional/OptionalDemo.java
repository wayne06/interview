package com.wnzhong.bjavaseadvance.hjava8.coptional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author wayne
 */
public class OptionalDemo {

    public static void main(String[] args) {

        Optional<String> name = Optional.of("WayneRooney");
        Optional<String> empty = Optional.ofNullable(null);

        if (name.isPresent()) {
            System.out.println(name.get());
        }

        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException ex) {
            System.out.println(ex.toString());
        }

        name.ifPresent(value -> System.out.println("Length of value : " + value.length()));

        System.out.println(empty.orElse("No value present."));
        System.out.println(name.orElse("Value exist."));

        System.out.println(empty.orElseGet(() -> "Default value."));
        System.out.println(name.orElseGet(() -> "Default value."));

        try {
            empty.orElseThrow(ValueAbsentException::new);
        } catch (Throwable ex) {
            System.out.println(ex.toString());
        }

        Optional<String> upperName = name.map(value -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found."));

        upperName = name.flatMap(value -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found."));

        Optional<String> longName = name.filter(value -> value.length() > 6);
        System.out.println(longName.orElse("name is less than 6 characters."));

        Optional<String> anotherName = Optional.of("Sana");
        Optional<String> shortName = anotherName.filter(value -> value.length() > 6);
        System.out.println(shortName.orElse("anotherName is less than 6 characters."));

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
