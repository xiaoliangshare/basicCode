package SerializableDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
public class Person implements Comparable<Person>, Serializable {
    // 指定序列化版本号
    private static final long serialVersionUID = 1L;

    transient private String name; // 如果使用transient表示该字段不需要序列化

    private Integer age;
    public Date birthday;

    //public Chinaese chinaese;

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
