package designpattern;

import java.util.HashMap;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/6/7
 * @time: 6:37 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class testDesign {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("main线程开始,用户注册");
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(100);
        System.out.println("main线程结束");

        HashMap<String, String> map = new HashMap<>();
        map.put("1","abc");

    }
}
// new Thread(() -> {
//         System.out.println(SignalDesign3.getSignalDesign3());
//         }).start();
//         new Thread(() -> {
//         System.out.println(SignalDesign3.getSignalDesign3());
//         }).start();
//         new Thread(() -> {
//         System.out.println(SignalDesign3.getSignalDesign3());
//         }).start();
//         new Thread(() -> {
//         System.out.println(SignalDesign3.getSignalDesign3());
//         }).start();
