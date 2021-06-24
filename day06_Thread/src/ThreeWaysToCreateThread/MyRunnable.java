package ThreeWaysToCreateThread;

/*
       java.lang.Runnable实现步骤：
            1、创建一个Runnable接口的实现类
            2、重写run(),设置线程任务
            3、创建实现类的对象
            4、创建Thread类对象，将实现类对象当参数传过来
            5、调用Thread类中的start方法，开启新的线程执行run()

       实现Runnable接口创建多线程的好处（工作推荐）：
            1、避免了java中的类的单继承局限性，实现Runnable，还可以实现其他接口，继承其他类,写的时候先继承再实现，不能反顺序：class Demo extends A implements B
            2、增强了程序的扩展性，降低了程序的耦合性，因为我每个Runnable的实现类都可以做不同的线程任务


*/
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
