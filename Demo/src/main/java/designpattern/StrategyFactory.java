package designpattern;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/12/18
 * @time: 11:27 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class StrategyFactory {
    private static final Map strategyMap = new HashMap();

    static {
        strategyMap.put("A", new ConcreteStrategyA());
        strategyMap.put("B", new ConcreteStrategyB());
        strategyMap.put("C", new ConcreteStrategyC());
    }

    /**
     * 获取策略
     * @param key
     * @return
     */
    public static Strategy getStrategy(String key) {
        if (StringUtils.isBlank(key)) {
            throw new IllegalArgumentException("key is null");
        }
        return (Strategy) strategyMap.get(key);
    }
}

// 类的初始化顺序：静态属性，静态代码块，普通属性，普通代码代码块，构造函数