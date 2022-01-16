package com.hh.entity;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/11/23
 * @time: 3:29 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
