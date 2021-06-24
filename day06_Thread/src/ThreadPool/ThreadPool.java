package ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
   线程池：在JDK 1.5之后提出的 java.util.concurrent.Executors线程池工厂类，用来生产线程池
        public static ExecutorService newFixedThreadPool(int nThreads) ：返回线程池对象。(创建的是有界线程池,也就是池中的线程个数可以指定最大数量)
        ExecutorService是一个线程池接口；
        其实返回的是ExecutorService接口的实现类对象，我们可以用ExecutorService接口来接收(面向接口编程)
        ExecutorService接口：
                public Future<?> submit(Runnable task) :获取线程池中的某一个线程对象，并执行；
                void shutdown(): 关闭/销毁线程池的方法

    使用线程池中线程对象的步骤：
         1. 创建线程池对象。
         2. 创建Runnable接口子类对象。(task)
         3. 提交Runnable接口子类对象。(take task)
         4. 关闭线程池(一般不做)。

*/
public class ThreadPool {
    public static void main(String[] args) {
        //1、创建一个线程池，池子里有2个线程
        ExecutorService es = Executors.newFixedThreadPool(2);

        //2、创建Runnable接口子类对象,创建一个线程任务。(task)
        RunnableImpl run=new RunnableImpl();

        //3、提交Runnable接口子类对象,开启线程执行run()。(take task)
             //线程池会一直开启，使用完了线程，会自动把线程归还给线程池，线程可以继续执行
        es.submit(run);
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());

        //es.shutdown(); 一般不做
    }
}
