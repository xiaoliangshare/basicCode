/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/4/8
 * @time: 2:28 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public enum Duanzhi {
    COMPANY("company","公司段","SEGMENT1"),
    DEPARTMENET("department","部门段","SEGMENT2"),
    BGBU("bgbu","bgbu段","SEGMENT8"),
    PROJECT("project","项目段","SEGMENT6"),
    SUBJECT("subject","科目段","SEGMENT4"),
    PRODUCT("product","产品段","SEGMENT5"),
    CITY("city","城市段","SEGMENT3"),
    CURRENT_SEGMENT("currentSegment","往来段","SEGMENT7");

    private String code;
    private String name;
    private String segment;
    Duanzhi(String code,String name,String segment) {
        this.code=code;
        this.name = name;
        this.segment=segment;
    }

    public static Duanzhi getEnumByCode(String code) {
        for (Duanzhi dataEnum : Duanzhi.values()) {
            if (dataEnum.code.equals(code)) {
                return dataEnum;
            }
        }
        return null;
    }

}
