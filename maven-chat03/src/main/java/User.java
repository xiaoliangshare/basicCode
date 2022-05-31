/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/5/30
 * @time: 10:01 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */

public class User {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
