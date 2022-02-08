import org.junit.Test;
import springJDBC.User;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/10/25
 * @time: 10:36 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class testProperties {

    public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
        List<List<T>> listArray = new ArrayList<>();
        for (int i = 0; i < list.size(); i += pageSize) {
            int toIndex = i + pageSize > list.size() ? list.size() : i + pageSize;
            listArray.add(list.subList(i, toIndex));
        }
        return listArray;
    }

    @Test
    public void testPro() throws IOException {
        Properties properties = new Properties();
//        InputStream resourceAsStream = testProperties.class.getClassLoader().getResourceAsStream("jdbc.properties");
//        properties.load(resourceAsStream);

//        URL resource = testProperties.class.getClassLoader().getResource("src/jdbc.properties");
//        String path = resource.getPath();
//        properties.load(new FileReader(path));
//
//        String url = properties.getProperty("url");
//        String user = properties.getProperty("user");
//        System.out.println("url:" + url + ",user:" + user);
//        String s = System.lineSeparator();
//        System.out.print("xxxx");
//        System.out.print("fff");


        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");

        List<String> strings2 = new ArrayList<>();
        strings2.add("1");
        strings2.add("2");

        //boolean b = strings.removeAll(strings2);

        List<List<String>> lists = splitList(strings, 2);
        lists.stream().forEach(
                list -> {
                    System.out.println(list.size());
                }
        );

        System.out.println(Integer.parseInt("1"));
        System.out.println();

//        for (int i = 0; i < strings.size(); i = i + 200) {
//            System.out.print(strings.subList(i, i + 200));
//
//        }


        System.out.println(String.format("list数据，%s", strings));


    }

    @Test
    public void testSort() {
        List<Integer> integers = new ArrayList<>();
        integers.add(43);
        integers.add(1);
        integers.add(55);

        String s = "21,3,10";
        List<Integer> collect = Arrays.asList(s.split(",")).stream().map(Integer::valueOf).sorted().collect(Collectors.toList());
        // Collections.sort(collect);
        System.out.println(collect);


        List<User> users = new ArrayList<>();
        users.add(new User(1, "32", "WMS-124"));
        users.add(new User(2, "2", "WMS-123"));
        users.add(new User(3, "10", "WMS-125"));
        System.out.println(users);

        users = users.stream().sorted(Comparator.comparing(User::getUsername)).collect(Collectors.toList());
        System.out.println("====排序之后的user===");
        System.out.println(users);

    }

    @Test
    public void testStream() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "32", "aa"));
        users.add(new User(2, "2", "aa"));
        users.add(new User(3, "10", "aa"));
        System.out.println(users);

        users = users.stream().filter(user -> user.getUsername().equals("200")).collect(Collectors.toList());

        //boolean noneMatch = users.stream().noneMatch(user -> user.equals("10"));
        System.out.println(users);
    }


    // "pacPrice":"0E-10"
    @Test
    public void testPacPrice() {
        String str = "0E-10";
        String str1 = "0.0000000000";

        //new BigDecimal()
        BigDecimal bigDecimal = new BigDecimal(str1);
        System.out.println(bigDecimal);
        //System.out.println(bigDecimal.add(new BigDecimal(1)));
    }
}
