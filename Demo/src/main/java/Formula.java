/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/7/16
 * @time: 7:29 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */

//java8新特性1：Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法
@FunctionalInterface
public interface Formula {
    double calculate(int a);
    static void method(){
        System.out.println("HELLO");
    }
    default double sqrt(double num){
        return Math.sqrt(num);
    }
}
