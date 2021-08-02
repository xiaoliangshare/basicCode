package day8_1;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/8/2
 * @time: 10:41 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public enum Color {
    RED("001","红色"),
    BLUE("002","蓝色");
    private final String code;
    private final String name;

    Color(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
