import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/16
 * @time: 7:29 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class xintexing<F, T> {
    private F fData;
    private T tData;

    public void convertMethod(Converter<F, T> converter) {
        T tData = converter.convert(fData);
        System.out.println(tData);
    }

    public static void main(String[] args) {
//        xintexing<String, Integer> xintexing = new xintexing<>();
//        xintexing.convertMethod(Integer::new);
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(5,7,8);
        List<Integer> temp = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());

        list1=temp;
        System.out.println(list1);




    }

}
