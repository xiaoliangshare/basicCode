package Producer_Consumer;

public class TestBaoZi {
    public static void main(String[] args) {
        //创建包子铺线程
        BaoZi bz=new BaoZi();
        BaoZiPu bzp=new BaoZiPu("包子铺线程",bz);
        bzp.start();

        //创建吃货线程
        ChiHuo ch=new ChiHuo("吃货线程",bz);
        ch.start();
    }
}
