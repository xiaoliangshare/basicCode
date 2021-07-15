import java.io.PrintStream;
import java.io.Serializable;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/15
 * @time: 10:00 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class User implements Serializable {
    private String username;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
