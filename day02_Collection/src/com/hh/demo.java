package com.hh;

import com.hh.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/11/23
 * @time: 3:27 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class demo {
    public static void main(String[] args) {
        List<Person> list=new ArrayList<>();
        list.add(new Person(20,"LHH"));
        list.add(new Person(20,"LHH1"));
        list.add(new Person(20,"LHH2"));
        list.add(new Person(20,"LHH3"));
        list.add(new Person(20,null));
        list.add(new Person(20,"LHH5"));

        List<String> collect = list.stream().map(Person::getName).collect(Collectors.toList());
        String str = list.stream().map(Person::getName).collect(Collectors.joining("_"));

        System.out.println(collect);

    }
}
