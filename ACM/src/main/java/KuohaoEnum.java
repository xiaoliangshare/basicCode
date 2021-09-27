import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 各种括号枚举
 * @author: lianghaohong
 * @date: 2021/9/13
 * @time: 9:41 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Getter
public enum KuohaoEnum {
    Little_left(1, "("),
    Little_right(9, ")"),
    Middle_left(2, "["),
    Middle_right(8, "]"),
    Big_left(3, "{"),
    Big_right(7, "}"),
    ;

    private static Map<Integer, String> codeNameMap = new HashMap<>();
    private static Map<String, Integer> nameCodeMap = new HashMap<>();

    static {
        for (KuohaoEnum kuohaoEnum : KuohaoEnum.values()) {
            codeNameMap.put(kuohaoEnum.getCode(), kuohaoEnum.getName());
            nameCodeMap.put(kuohaoEnum.getName(), kuohaoEnum.getCode());
        }
    }

    private final Integer code;
    private final String name;

    KuohaoEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
    public static Integer getCodeByName(String name){
        if (name.equals("(") ||name.equals(")") ||name.equals("[") ||name.equals("]") ||
                name.equals("{") ||name.equals("}")){
            return nameCodeMap.get(name);
        }
        return null;
    }

    public static String getNameByCode(Integer code){
        return codeNameMap.get(code);
    }


}
