package ThreeWaysToCreateThread;

import java.util.List;

/*
    自定义线程类：继承Thread类, 在子类中可以直接使用这些方法
            public String getName() :获取当前线程名称。
            public void start() :导致此线程开始执行; Java虚拟机调用此线程的run方法。
            public void run() :此线程要执行的任务在此处定义代码。
            public static void sleep(long millis) :使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）。
            public static Thread currentThread() :返回对当前正在执行的线程对象的引用。
*/
public class MyThread extends Thread {
    //利用继承中的特点将线程名称传递进行设置, 如果直接new ThreeWaysToCreateThread.MyThread();则getName()的名字为：Thread-0,Thread-1...
    public MyThread(){}
    public MyThread(String name){
        super(name);
    }//记住：以后添加了带参构造函数，无参的也要带上，要么写两个，要么一个都不写

    //重写run方法，定义线程要执行的代码
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("线程"+getName()+" "+i); //可以直接使用getName(),因为父类中有
        }
    }
}
