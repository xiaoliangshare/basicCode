
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
                new User("zhangsan1", 20),
                new User("zhangsan2", 30),
                new User("lisi", 20),
                new User("wangwu", 30)
        );

        //Lists.newArrayList();
        //list.forEach 和 list.stream().forEach()的效果是一样的
        users.forEach(
                user -> System.out.println(user.getUsername())
        );
        users.stream().forEach(
                user -> System.out.println(user.getUsername())
        );

        int fenshu = users.stream()
                .filter(user -> user.getUsername().equals("zhangsan"))
                .mapToInt(User::getAge)//函数引用
                .max().getAsInt();
        System.out.println("fenshu" + fenshu);
        int fenshu1 = users.stream()
                .filter(user -> user.getUsername().equals("zhangsan"))
                .mapToInt(User::getAge)//函数引用
                .sum();
        System.out.println("fenshu:" + fenshu);


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

        List<String> ints = Arrays.asList("32", "43", "55", "3");
        int maxint = ints.stream()
                .mapToInt(Integer::valueOf)
                .filter(num -> num > 5).limit(3)
                .max().getAsInt();

        System.out.println(maxint);

        Stream<String> stream = Arrays.stream(new String[]{"11", "22", "33", "55"});
        stream.toArray(String[]::new);
        Stream.of(new String[]{"11", "22", "33", "55"}, new int[]{1, 2, 3, 4});

        /**
         * 将list-->map,(key1, key2) -> key2 >= key1 ? key2 : key1)是解决key值相同的逻辑
         */
        Map<String, Integer> map = users.stream()
                .collect(Collectors.toMap(User::getUsername, User::getAge, (key1, key2) -> key2 >= key1 ? key2 : key1));
        Map<String, User> map1 = users.stream()
                .collect(Collectors.toMap(User::getUsername, o -> o));
        System.out.println(map);
        System.out.println(map1);


    }
}
/**
 * 总结：对 Stream 的使用就是实现一个 filter-map-reduce 过程，产生一个最终结果,以后对list集合的操作都采用流的方式
 * 对集合：
 * 常用list.stream()，通常配合Arrays.asList(),但是没有add()和remove(),必要时需要再包一层List<User> users=new ArrayList<>(list);
 * 对数组：
 * Arrays.stream(T[] array)/Stream.of()
 */