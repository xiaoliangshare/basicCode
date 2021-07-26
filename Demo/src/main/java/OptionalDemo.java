import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
     * orElse()方法不管null与否都返回指定的值
     * orElseGet()当判断的实例为空时候返回一个指定的实例。
     */
    public static void main(String[] args) {
        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println("Full Name is set? " + fullName.isPresent());
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[orElseGet]"));
        System.out.println("Full Name: " + fullName.orElse("[orElse]"));
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
        System.out.println("======");


        Optional<String> firstName = Optional.ofNullable("Tom");
        System.out.println("First Name is set? " + firstName.isPresent());
        System.out.println("Full Name: " + firstName.orElse("[orElse]"));
        System.out.println("First Name: " + firstName.orElseGet(() -> "[none]"));
        System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
        System.out.println();


        Optional.ofNullable("tom").ifPresent(System.out::println);
        Optional.ofNullable("tom").ifPresent(
                s -> {
                    System.out.println(s + "lhh");
                    System.out.println(s + "lhh2");
                    System.out.println(s + "lhh3");
                    System.out.println(s + "lhh4");
                    System.out.println(s + "lhh5");
                }
        );
        Optional.ofNullable("tom").orElseThrow(() -> new RuntimeException("wrong"));


        List<User> users = Arrays.asList(
                new User("zhangsan", 10),
                new User("zhangsan", null),
                new User("zhangsan2", 30),
                new User("lisi", 20),
                new User("wangwu", 30),
                new User("xx", 30)
        );


        //循环判断空
        users.stream()
                .filter(user -> user.getUsername().equals("zhangsan"))
                //.map()
                .forEach(user -> {
                            Integer integer = Optional.ofNullable(user)//这里可以不用写user.getAge()
                                    .map(User::getAge)//等价于.map(u->u.getAge())
                                    .map(age -> age + 1)
                                    .orElseGet(() -> {
                                        return 20;
                                    });
                            System.out.println(integer);
                        }
                );


//        Optional.ofNullable(receipt.getExtraInfo()).ifPresent(
//                extinfo->warehouseOut.setExtraInfo(JSON.toJSONString(extinfo))
//        );

        initUser();

    }

    private static String show() {
        System.out.println("Optional判断的实例不管是否为null都会执行，但是它的返回值只有当null的时候才起作用");
        return "hello";
    }
    public static void initUser(){
        final User user = new User();//final意味着引用不可变罢了,但是可以修改这个对象的值
        user.setAge(12);

        //User user1 = new User("zz", 21);
        //user=user1;

        String name = "zyy";
        Optional.ofNullable(name).ifPresent(
                n ->{
                    user.setAge(13);
                    user.setUsername(n);
                }
        );
        modifyUserAge(user);
        System.out.println(user);
    }
    public static void modifyUserAge(User user){
        //user=new User();
        user.setAge(100);
    }
}

/**
 * if(user!=null){
 *    dosomething(user);
 * }
 *
 * Optional.ofNullable(user).ifPresent(u->{
 *    dosomething(u);
 * });
 */