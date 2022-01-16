import com.dianping.lion.shade.org.apache.curator.shaded.com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/11/23
 * @time: 3:37 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class PersonTest {
    // 实现组合
    public static void combinationSelect(String[] dataList, int dataIndex, String[] resultList, int resultIndex) {
        int resultLen = resultList.length;
        int resultCount = resultLen + 1;
        // 全部选择完时输出组合结果
        if (resultCount > resultLen) {
            System.out.println(resultList);
            return;
        }
        // 递归选择下一个
        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
            resultList[resultIndex] = dataList[i];
            combinationSelect(dataList, i + 1, resultList, resultIndex + 1);
        }
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(25, "LHH"));
        list.add(new Person(20, "LHH1"));
        list.add(new Person(240, "LHH2"));
        list.add(new Person(205, "LHH3"));
        list.add(new Person(260, null));
        list.add(new Person(2, "LHH5"));

        for (Person person : list) {
            System.out.print(person.getAge() + "-");
        }
        System.out.println("排序之前：============");
        Collections.sort(list, Comparator.comparingInt(Person::getAge));
        for (Person person : list) {
            System.out.print(person.getAge() + "-");
        }
//
//        List<String> collect = list.stream().map(Person::getName).collect(Collectors.toList());
//        String str = list.stream().map(Person::getName).collect(Collectors.joining("_"));
//
//        System.out.println(collect);
//        System.out.println(str);
//
//
//        Person person = new Person(25, "25");
//        person.setField1("field1");
//        person.setField4("field4");
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(person.getField1()).append(person.getField2()).append(person.getField3()).append(person.getField4());
//        System.out.println(stringBuilder);


//        List<String> dataList = new ArrayList<>();
//        List<List<String>> resultList = combinationSelect(dataList);

//        Map<String, String> map = new HashMap<>();
//        map.put("4", "D");
//        map.put("2", null);
//        map.put("3", null);
//        map.put("1", "A");
//        map.put("5", null);
//        System.out.println(map);
//
//        List<String> collect = map.keySet().stream().collect(Collectors.toList());
//        System.out.println("collect" + collect);
//
//        Map<String, String> newMap = map.entrySet().stream().filter((e) -> e.getValue() != null).collect(Collectors.toMap(
//                (e) -> e.getKey(),
//                (e) -> e.getValue()));
//        System.out.println(newMap);
//        newMap = sortByKey(newMap, false);
//        System.out.println(newMap);

        //System.out.println(newMap);
//        String s="A B C ";
//        String[] s1 = s.split(" ");
//
//        System.out.println(Arrays.asList(s1));
        Map<String, String> map = new HashMap<>();
        map.put("4", null);
        map.put("2", null);
        map.put("3", "22");
        map.put("5", null);
        System.out.println(map);
        Collection<String> values = map.values();


        if (map.values().stream().allMatch(value -> StringUtils.isBlank(value))) {
            System.out.println("==all null===");
        } else {
            System.out.println("====not all null=====");
        }


    }


    /**
     * 根据map的key排序
     *
     * @param map    待排序的map
     * @param isDesc 是否降序，true：降序，false：升序
     * @return 排序好的map
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, boolean isDesc) {
        Map<K, V> result = Maps.newLinkedHashMap();
        if (isDesc) {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }

    private static List<List<String>> combinationSelect(List<String> dataList) {
        List<String> resultList = new ArrayList<>();
        // 实现C m n
        return null;
    }
}
