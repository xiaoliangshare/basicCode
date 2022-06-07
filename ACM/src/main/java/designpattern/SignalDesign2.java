package designpattern;

/**
 * @description: 懒汉式单例模式
 * @author: lianghaohong
 * @date: 2022/6/7
 * @time: 5:53 下午
 * Copyright (C) 2022 Meituan All rights reserved
 */
public class SignalDesign2 {
    private SignalDesign2() {
    }

    // 注意需要是static类型的
    private static SignalDesign2 signalDesign2 = null;

    // 当实例为空时
    public static synchronized SignalDesign2 getSignalDesign2() {

        if (signalDesign2 == null) {
            signalDesign2 = new SignalDesign2();
        }
        return signalDesign2;
    }

  // 不过这种情况容易出现线程安全问题，被synchronized修饰的非静态方法，锁的是调用者对象本身
    // 不过这种方式性能很低，不是很推荐，后面就有了 DCL（双重检测机制）+ volatile关键字的懒汉式
}
