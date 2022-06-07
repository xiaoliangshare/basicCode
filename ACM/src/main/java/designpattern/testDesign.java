package designpattern;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/6/7
 * @time: 6:37 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class testDesign {
    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println(SignalDesign3.getSignalDesign3());
        }).start();
        new Thread(() -> {
            System.out.println(SignalDesign3.getSignalDesign3());
        }).start();
        new Thread(() -> {
            System.out.println(SignalDesign3.getSignalDesign3());
        }).start();
        new Thread(() -> {
            System.out.println(SignalDesign3.getSignalDesign3());
        }).start();
        new Thread(() -> {
            System.out.println(SignalDesign3.getSignalDesign3());
        }).start();
    }
}
