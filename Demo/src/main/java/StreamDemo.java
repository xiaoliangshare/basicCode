import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/16
 * @time: 11:22 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("zhangsan", 10),
                new User("zhangsan", 220),
                new User("zhangsan", 2220),
                new User("lisi", 20),
                new User("wangwu", 30)
        );

        users.forEach(
                user -> System.out.println(user.getUsername())
        );
        users.stream().forEach(
                user -> System.out.println(user.getUsername())
        );

        int fenshu = users.stream()
                .filter(user -> user.getUsername().equals("zhangsan"))
                .mapToInt(User::getAge)//函数引用
                .sum();
        List<Integer> zhangsan = users.stream()
                .filter(user -> user.getUsername().equals("zhangsan"))
                .map(user -> user.getAge())//转化为Integer流
                .collect(Collectors.toList());

        IntStream zhangsan1 = users.stream()
                .filter(user -> user.getUsername().equals("zhangsan"))
                .mapToInt(User::getAge);

        Stream<Integer> zhangsan2 = users.stream()
                .filter(user -> user.getUsername().equals("zhangsan"))
                .map(User::getAge);


        /**
         * 总结：以后对list集合的操作都采用流的方式
         */



    }
}
