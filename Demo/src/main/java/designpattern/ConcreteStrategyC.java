package designpattern;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/12/18
 * @time: 11:19 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class ConcreteStrategyC implements Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("去调WMS获取仓库接口");
    }
}
