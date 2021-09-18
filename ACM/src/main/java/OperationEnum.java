import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 设置每个操作符对应的权重
 * @author: lianghaohong
 * @date: 2021/9/11
 * @time: 11:05 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Getter
public enum OperationEnum {
    plus(1,"+"),
    reduce(1,"-"),
    ride(2,"*"),
    except(2,"/"),
    parentheses_left(0,"("),
    parentheses_right(3,")"),
    ;

    private final Integer weight;
    private final String name;

    OperationEnum(Integer weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    private static Map<Integer,String> cnMap = new HashMap<>();
    private static Map<String,Integer> ncMap = new HashMap<>();
    static {
        for (OperationEnum accStatus : OperationEnum.values()) {
            cnMap.put(accStatus.getWeight(), accStatus.getName());
            ncMap.put(accStatus.getName(), accStatus.getWeight());
        }
    }
    public static String getNameByWeight(Integer weight){
        return cnMap.get(weight);
    }
    public static Integer getWeightByName(String name){
        return ncMap.get(name);
    }
}
