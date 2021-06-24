package ThreadPool;
/*
     2. 创建Runnable接口子类对象。(task)
*/
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建了一个新的线程");
    }
}
