package ThreeWaysToCreateThread;

public class TestMyThread {
    public static void main(String[] args) {
        System.out.println("这是主线程");
        MyThread t=new MyThread("HH");//等价于t.setName("PP");
        t.start();//开启新的线程，相当于开辟了一条通向cpu的新路径来执行run方法
        new MyThread().start();//再开启一个线程
        new MyThread().start();//又开启一个线程，但是这三个线程执行的任务都一样，都是打印0-9



        System.out.println(Thread.currentThread().getName());//获取当前正在执行的线程名称,这里就是main
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程main:"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
