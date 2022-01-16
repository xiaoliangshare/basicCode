package designpattern;

/**
 * @description: 策略类的定义比较简单，包含一个策略接口和一组实现这个接口的策略类。因为所有的策略类都实现相同的接口，所以，客户端代码基于接口而非实现编程，可以灵活地替换不同的策略
 * @author: lianghaohong
 * @date: 2021/12/18
 * @time: 11:16 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public interface Strategy {
    void algorithmInterface();

}
