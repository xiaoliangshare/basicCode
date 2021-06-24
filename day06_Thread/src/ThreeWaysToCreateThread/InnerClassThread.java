package ThreeWaysToCreateThread;

/*
        匿名内部类创建线程，作用就是简化代码
        好处和弊端：
            一方面，匿名内部类可以帮我们省去实现类的定义；另一方面，匿名内部类的语法——确实太复杂了！
        格式：
             new 父类/接口(){
                 重写父类/接口中的方法
             }

*/
public class InnerClassThread {
    public static void main(String[] args) {
        //new ThreeWaysToCreateThread.MyThread().start() 或者 new ThreeWaysToCreateThread.MyRunnable()
        new Thread(){
            //重写run()
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"Thread"+i);
                }
            }
        }.start();//这里就创建了Thread-0线程



        //线程的接口Runnable
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "Runnable" + i);
                }
            }
        };
        new Thread(run).start();


        //这是实现接口的更简洁版本（推荐）
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            System.out.println(Thread.currentThread().getName() + "Runnable" + i);
                        }
                    }
                }
        ).start();






    }
}
