package ThreeWaysToCreateThread;

import static java.lang.Thread.yield;

public class TestMyThread {
    public static void main(String[] args) {
        System.out.println("这是主线程");
        MyThread t = new MyThread("HH");//等价于t.setName("PP");
        t.start();//开启新的线程，相当于开辟了一条通向cpu的新路径来执行run方法
        new MyThread().start();//再开启一个线程
        new MyThread().start();//又开启一个线程，但是这三个线程执行的任务都一样，都是打印0-9
        /**
         * 总结：开辟栈内存空间的顺序是: main-->HH-->Thread-0-->Thread-1，当执行线程的任务结束了，线程自动在栈内存中释放了
         *      然后这4个线程并发执行任务，java使用的线程调度方式为：抢占式调度
         */


        System.out.println(Thread.currentThread().getName());//获取当前正在执行的线程名称,这里就是main
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程main:" + i);
            System.out.println("当前线程优先级为："+Thread.currentThread().getPriority());
            try {
                yield();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/**
 * 首先多线程有个概念很重要：共享变量，全局变量
 * 1、线程安全是针对共享变量说的，如果在多线程环境下和单线程环境下执行完某一任务之后，该共享变量的值都是一致的，我们说这个全局变量是线程安全的
 * 2、线程同步是两个或多个线程为了共同完成某一任务而相互等待，相互协调次序的过程就是线程同步
 * (线程同步的真实意思，其实是“排队”：几个线程之间要排队，一个一个对共享资源进行操作，而不是同时进行操作。)
 * 目的就是实现对共享变量的互斥访问，互斥是结果，同步是手段。Java中提供了同步机制 (synchronized)来实现线程同步。
 */