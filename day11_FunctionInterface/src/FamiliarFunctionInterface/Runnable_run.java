package FamiliarFunctionInterface;

/*
       例如 java.lang.Runnable 接口就是一个函数式接口
            run():  线程工作主体方法

       这也是函数式接口的使用1、作为方法的参数：show(()->{})
*/
public class Runnable_run {
    public static void main(String[] args) {
        //普通式调用
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"启动了。");
            }
        });
        //Lambda式调用
        startThread(()->{
            System.out.println(Thread.currentThread().getName()+"启动了。");
        });
    }

    //定义一个开启线程的方法
    public static void startThread(Runnable runnable){
        new Thread(runnable).start();
    }
}
