package Producer_Consumer;
/*
    等待唤醒机制其实就是经典的“生产者与消费者”的问题。
    什么是等待唤醒机制: 就是多个线程间的一种协作机制。
    调用wait和notify方法需要注意的细节：
           1. wait方法与notify方法必须要由同一个锁对象调用。因为：对应的锁对象可以通过notify唤醒使用同一个锁对象调用的wait方法后的线程。
           2. wait方法与notify方法是属于Object类的方法的。因为：锁对象可以是任意对象，而任意对象的所属类都是继承了Object类的。
           3. wait方法与notify方法必须要在同步代码块或者是同步函数中使用。因为：必须要通过锁对象调用这2个方法。
*/
public class BaoZi {
    String pi; //皮
    String xian; //馅
    public BaoZi(){}
    public BaoZi(String pi, String xian) {
        this.pi = pi;
        this.xian = xian;
    }

    boolean flag=false;// 包子状态
}
