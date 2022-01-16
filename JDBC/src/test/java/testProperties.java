import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadPoolExecutor;

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

        boolean b = strings.removeAll(strings2);

        List<List<String>> lists = splitList(strings, 5);
        lists.stream().forEach(
                list -> {
                    System.out.println(list.size());
                }
        );


        Integer.parseInt("1");
        System.out.println();

//        for (int i = 0; i < strings.size(); i = i + 200) {
//            System.out.print(strings.subList(i, i + 200));
//
//        }

    }
}
