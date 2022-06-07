package designpattern;

/**
 * @description: 使用静态内部类来
 * @author: lianghaohong
 * @date: 2022/6/7
 * @time: 6:33 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class SignalDesign3 {

    private SignalDesign3() {
    }

    // 使用静态内部类来初始化
    private static class LazyHolder {
        private static final SignalDesign3 SIGNAL_DESIGN_3 = new SignalDesign3();
    }

    //提供对外访问方法
    public static final SignalDesign3 getSignalDesign3() {
        return LazyHolder.SIGNAL_DESIGN_3;
    }
    //当任何一个线程第一次调用getInstance()时，都会使LazyHolder被加载和被初始化，此时静态初始化器将执行SIGNAL_DESIGN_3的初始化操作。(被调用时才进行初始化！)

    //初始化静态数据时，Java提供了的线程安全性保证。(所以不需要任何的同步)
    // 开启spring事务意味着使用数据库的锁

}
