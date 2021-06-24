package Producer_Consumer;

/*
        等待唤醒案例：线程之间的通信
              创建一个消费者线程，告知老板要的包子种类和数量，调用wait(),进入Waitting状态(无线等待状态)
              创建一个生产者线程，花了5秒做包子，做好之后调用notify(),唤醒顾客吃包子
        注意：
              顾客和老板线程必须使用同步代码块包裹起来，保证等待和唤醒只有一个在执行
              只有锁对象才能调用wait()和notify()
        Object类中的方法
              wait(): 在其他对象调用此对象的notify()或者notifyAll()之前，导致当线程等待。
              notify(): 唤醒在此对象监视器上等待的单个线程，会继续执行wait()方法之后的代码
*/
public class WaitAndNotify {
    public static void main(String[] args) {
        Object obj=new Object();

        //创建一个顾客线程(消费者)
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        //一直等待买包子
                        while(true){
                            //保证等待和唤醒只有一个在执行
                            synchronized (obj){
                                System.out.println("告知老板要的包子种类和数量");
                                //调用wait(),进入Waitting状态
                                try {
                                    obj.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                //唤醒之后执行的代码
                                System.out.println("包子已经做好了，开吃！");
                                System.out.println("---------------------");
                            }
                        } 
                    }
                }
        ).start();

        //创建一个老板线程(生产者)
        new Thread(){
            @Override
            public void run() {
                //while(true){} 代表老板一直在做包子
                while(true){
                    //花了5秒做包子
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //保证等待和唤醒只有一个在执行,需要使用同步技术
                    synchronized (obj){
                        System.out.println("老板5秒之后做好包子，告知顾客可以吃包子了");
                        obj.notify();
                    }
                }
            }
        }.start();
    }
}

