package _File;
/*
      递归注意：
            一定要有限定条件，递归次数也不能太多，否则会发生栈内存溢出（StackOverFlowError）
            使用的前提： 调用的时候方法的主体不变，方法的参数不同。
            构造方法不能递归。

*/
public class Recurison {
    public static void main(String[] args) {
        System.out.println(getSum(3));
        System.out.println(multiple(3));
    }

    //计算1~ n的和
    public static int getSum(int n){
        if (n==1){
            return 1;
        }
        return n+getSum(n-1);
    }

    //求n的阶乘
    public static int multiple(int n){
        if (n==1){
            return 1;
        }
        return n*multiple(n-1);
    }
}
