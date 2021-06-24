package com.hh;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/6/23
 * @time: 4:15 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public enum IDs {

    //成功
    SUCCESS(200, "success"),
    //学校300-399
    ERROR(301, "error");

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    IDs(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


}
