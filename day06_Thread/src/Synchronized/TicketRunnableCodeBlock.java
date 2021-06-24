package Synchronized;

/*
       用synchronizd代码块来实现卖票案例的线程安全
       格式：
            synchronized(锁对象){  锁对象可以是任意对象,但是必须保证多个线程使用的锁对象是同一个
                可能会出现线程安全问题的代码(就是访问了共享数据的代码)
            }
*/
public class TicketRunnableCodeBlock implements Runnable {
    private int ticket = 100;
    Object obj=new Object();//这里必须在外面创建，否则每个线程创建一个，对象就不唯一了

    //run()就是卖票
    @Override
    public void run() {
        while (true) {
            synchronized (obj){
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
}
