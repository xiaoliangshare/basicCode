import java.util.Optional;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/16
 * @time: 10:46 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class OptionalDemo {
    /**
     * 如果Optional实例持有一个非空值，则isPresent()方法返回true，否则返回false；
     * orElseGet()方法，Optional实例持有null，则可以接受一个lambda表达式生成的默认值；
     * map()方法可以将现有的Opetional实例的值转换成新的值；
     * orElse()方法与orElseGet()方法类似，但是在持有null的时候返回传入的默认值。
     */
    public static void main(String[] args) {
        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println("Full Name is set? " + fullName.isPresent());
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        System.out.println("Full Name: " + fullName.orElse("[none]"));
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
        System.out.println("======");


        Optional<String> firstName = Optional.of("Tom");
        System.out.println("First Name is set? " + firstName.isPresent());
        System.out.println("First Name: " + firstName.orElseGet(() -> "[none]"));
        System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
        System.out.println();
    }
}

