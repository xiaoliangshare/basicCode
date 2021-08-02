package Synchronized;

/*
       用synchronizd方法来实现卖票案例的线程安全
       格式：
            public synchronized void method(){
                 可能会产生线程安全问题的代码
             }
       同步锁是谁?
                对于非static方法,同步锁就是this,也就是线程类的实现类对象(runTicket)
                对于static方法,我们使用当前方法所在类的字节码对象(类名.class,即TicketRunnableFunction.class)
*/
public class TicketRunnableFunction implements Runnable {
    private static int ticket = 100;

    //run()就是卖票
    @Override
    public void run() {
        while (true) {
            //sellTicket();
            sellTicketStatic();
        }

    }

    //非静态方法
    public synchronized void sellTicket(){
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

    //静态方法
    public static synchronized void sellTicketStatic(){
        if (ticket > 0) {
            //提高安全问题出现的概率，让程序睡眠
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
            ticket--;
        }
    }
}
