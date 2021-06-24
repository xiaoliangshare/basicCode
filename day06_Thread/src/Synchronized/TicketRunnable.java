package Synchronized;

/*
       以卖票案例来实现线程安全
*/
public class TicketRunnable implements Runnable {
    private int ticket = 100;

    //run()就是卖票
    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                //提高安全问题出现的概率，让程序睡眠
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                ticket--;
            }
        }

    }
}
/*
     这种情况会发现存在卖重复的票，即出现了线程安全问题
         Thread-1正在卖第100张票
         Thread-0正在卖第100张票
         Thread-2正在卖第100张票
         总结一下：
                我们这里说的同时都是指是指宏观上，其实质是线程的并发执行
                线程安全就是多个线程同时访问共享数据，如果执行的结果和单线程下的执行结果相同就说明是线程安全的。
                线程同步它是一种机制，是为了保证线程安全的一种机制，安全是目的，同步是手段(更细节的就是实现互斥)
                有三种方式完成同步操作：1. 同步代码块。 2. 同步方法。 3. 锁机制。
*/