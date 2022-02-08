package CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2022/2/8
 * @time: 6:26 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class TestRunnable implements Runnable {
    /**
     * 处理main线程阻塞，等待所有子线程
     */
    private CountDownLatch countDownLatch;

    /**
     * 线程名字
     */
    private String threadName;

    // 构造函数
    public TestRunnable(CountDownLatch countDownLatch, String threadName) {
        this.countDownLatch = countDownLatch;
        this.threadName = threadName;
    }


    /**
     * 任务方法
     */
    @Override
    public void run() {
        System.out.println("[" + threadName + "]Running![countDownLatch.getCount()=" + countDownLatch.getCount() + "].");
        countDownLatch.countDown();
    }


    public static void main(String[] args) {
        // 这里相当于是主线程
        int countNum = 5;
        CountDownLatch countDownLatch = new CountDownLatch(countNum);
        for (int i = 0; i < countNum; i++) {
            new Thread(new TestRunnable(countDownLatch, "子线程" + i)).start();
        }

        //
        System.out.println("主线程阻塞，等待所有子线程执行完成！");


        try {
            countDownLatch.await(); // 阻塞main线程，只有当子线程完成之后才执行，即countDown()为0才继续执行下面的语句
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有线程执行完成！");
    }
}
