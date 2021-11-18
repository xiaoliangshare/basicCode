package reflex;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/18
 * @time: 12:00 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Comparable<Person> {
    private String name;
    private Integer age;
    public Date birthday;

    public void eat() {
        System.out.println("人都会吃东西");
    }

    public void eat(String food) {
        System.out.println("人都会吃" + food);
    }

    @Override
    public int compareTo(Person o) {
        return this.getAge() - o.getAge();
    }
}
