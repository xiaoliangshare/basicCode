package Producer_Consumer;

public class ChiHuo extends Thread {
    private BaoZi bz;
    public ChiHuo(){}
    public ChiHuo(String name,BaoZi bz){
        super(name);
        this.bz=bz;
    }
    //设置线程任务：吃包子
    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if (bz.flag==false){//如果没有包子就等着包子铺生产
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒之后开始吃包子
                System.out.println("吃货正在吃"+bz.pi+bz.xian+"包子");
                bz.flag = false;
                bz.notify();//唤醒包子铺
            }
        }
    }
}
