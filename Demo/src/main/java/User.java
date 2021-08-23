import day8_1.MyAnoo;
import lombok.Data;
import lombok.NoArgsConstructor;
import reflex.Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/15
 * @time: 10:00 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Data
@NoArgsConstructor
public class User implements Serializable, Comparable<User> {
    private String username;
    private Integer age;

    //public User(){}
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.getAge()-o.getAge();
    }

    @MyAnoo
    public void show(){
        System.out.println("User类中的show方法执行了");
    }

    public Person getPerson(){
        Person person = new Person();
        person.setAge(100);
        person.setName("lhh");
        person.setBirthday(new Date());
        return person;
    }
}
