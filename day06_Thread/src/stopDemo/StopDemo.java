package stopDemo;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/4/8
 * @time: 9:47 上午
 * Copyright (C) 2022 Meituan All rights reserved
 */
public class StopDemo {
    private static User user = new User();

    public static void main(String[] args) {

        // 开启一个写线程
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (user) {

                    }
                }
            }
        });


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.stop();



        // 开启一个读线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (user){

                    }
                }
            }
        }).start();



    }

}
