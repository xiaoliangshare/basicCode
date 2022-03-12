import lombok.Data;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/3/12
 * @time: 4:25 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Data
public class User {
    private String username;
    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
