package Producer_Consumer;

/*
        注意：
            1、包子铺线程和吃货线程的关系是通信关系(互斥)
            2、必须使用同步技术保证两个线程只有一个在执行
            3、锁对象必须唯一

*/
public class BaoZiPu extends Thread{
    private BaoZi bz;
    public BaoZiPu(){}
    public BaoZiPu(String name,BaoZi bz){
        super(name);//设置线程的名字
        this.bz=bz;
    }

    @Override
    public void run() {
        int count=0;
        while (true){//让包子铺一直生产包子
            synchronized (bz){
                //对包子的状态进行判断,有包子则等待先不做包子
                if (bz.flag==true){
                    try {
                        bz.wait();//让自己等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒之后开始生产包子
                if (count%2==0){
                    //生产三鲜馅的包子
                    bz.pi="薄皮";
                    bz.xian="三鲜";
                }else{
                    //生产五仁馅的包子
                    bz.pi="冰皮";
                    bz.xian="五仁";
                }
                count++;
                bz.flag=true;
                System.out.println("包子造好了："+bz.pi+bz.xian);
                System.out.println("吃货来吃包子吧");
                //唤醒等待线程
                bz.notify();//唤醒别人(吃货)
            }
        }
    }
}
