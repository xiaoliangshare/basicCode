package designpattern;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/12/18
 * @time: 11:17 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class ConcreteStrategyA implements Strategy{

    @Override
    public void algorithmInterface() {
        System.out.println("去调MDM获取商品接口");
    }
}
