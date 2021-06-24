package Synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
        Java.util.current.locks.Lock
        用Lock锁来实现卖票案例的线程安全
        Lock 机制提供了比synchronized代码块和synchronized方法更广泛的锁定操作
        Lock接口中的方法：
             void lock() 获取锁
             void unlock() 释放锁
        ReentrantLock implements Lock
        使用步骤：
                1、在成员位置创建一个ReentrantLock对象
                2、在可能会出现安全代码的前面
*/
public class TicketRunnableLock implements Runnable {
    private static int ticket = 100;
    Lock lock =new ReentrantLock();


    //run()就是卖票
    @Override
    public void run() {
        while (true) {
            lock.lock();//加锁
            if (ticket > 0) {
                //提高安全问题出现的概率，让程序睡眠
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();//释放锁,写在finally的好处是无论是否出现异常锁都会被释放掉
                }
            }
        }
    }


}
