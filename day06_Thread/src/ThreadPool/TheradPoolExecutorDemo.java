package ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 使用ThreadPoolExecutor创建线程池
 * @author: lianghaohong
 * @date: 2021/8/26
 * @time: 8:17 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class TheradPoolExecutorDemo {
    public static void main(String[] args) {
        // 创建一个线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                5,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.DiscardPolicy() // 拒接策略
        );

        // 获取队列中在排队的任务量
        System.out.println("getQueue:" + threadPoolExecutor.getQueue().size());

        //获取此时队列中的剩余容量
        System.out.println("remainingCapacity：" + threadPoolExecutor.getQueue().remainingCapacity());

        RunnableImpl run=new RunnableImpl();

        Future<?> ret = threadPoolExecutor.submit(run);
        Future<?> ret1 = threadPoolExecutor.submit(run);
        Future<?> ret2 = threadPoolExecutor.submit(run);



    }
}
