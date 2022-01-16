package designpattern;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/12/18
 * @time: 11:18 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class ConcreteStrategyB implements Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("去调PMS获取供应商接口");
    }
}
