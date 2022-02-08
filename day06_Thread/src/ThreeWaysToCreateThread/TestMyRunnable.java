package ThreeWaysToCreateThread;

public class TestMyRunnable {
    public static void main(String[] args) {
        MyRunnable run = new MyRunnable();
        Thread t = new Thread(run);
        t.setName("HH");
        t.start(); //开启新线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

    }
}
