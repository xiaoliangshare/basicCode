package designpattern;

/**
 * @description: 单例设计模式：饿汉式(直接创建，不管你用不用)，懒汉式（用的时候才创建对象）
 * 单例模式体现了面向对象的思想
 * @author: lianghaohong
 * @date: 2022/6/7
 * @time: 5:46 下午
 * Copyright (C) 2022 Meituan All rights reserved
 */
public class SignalDesign {

    // 1、私有化构造函数
    private SignalDesign() {
    }

    //2、在类内部创建，static随着类的加载而加载
    private static SignalDesign signalDesign = new SignalDesign();

    // 3、提供获取唯一实例的方法
    public static SignalDesign getSignalDesign() {
        return signalDesign;
    }

}
