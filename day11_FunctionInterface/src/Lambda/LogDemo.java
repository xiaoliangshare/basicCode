package Lambda;
/*
     性能浪费的日志案例
*/
public class LogDemo {
    //定义一个日志的级别，显示相应级别的信息
    public static void showLog(int level,String msg){
        if (level==1){
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        //存在一个问题，没有level=2的方法，就会造成字符串拼接的浪费，解决方案：使用Lambda优化
        showLog(2, msgA + msgB + msgC);
    }
}
