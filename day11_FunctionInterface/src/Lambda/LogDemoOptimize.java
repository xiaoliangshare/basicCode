package Lambda;

/*
        使用Lambda优化日志案例
        Lambda的特点：延迟加载，使用的前提是必须创建函数式接口
*/
public class LogDemoOptimize {

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";

        //不会使用Lambda先写出显示匿名内部类
        /*showLog(2, new MessageBuilder() {
            @Override
            public String builderMessage() {
                return msgA + msgB + msgC;
            }
        });*/


        /*
             优化：再使用Lambda来做，当参数传过来之后，仅仅是把参数传递到showLog方法中
             只有满足条件，日志等级是1的时候才会调用接口MessageBuilder中的方法进行字符串拼接。
             如果条件不满足，日志等级不是1，那么接口中的方法不会执行，字符串也不会拼接，就不会存在性能浪费。
        */
        showLog(2,()->{
            //直接返回拼接之后的字符串
            System.out.println("验证一下：如果条件不满足不会执行，lever=2的时候这句话不会打印");
            return msgA + msgB + msgC;
        });
    }


    //定义一个显示日志的方法，参数传递日志的等级和MessageBuilder接口
    public static void showLog(int level, MessageBuilder mb){
        if (level==1){
            String logMsg = mb.builderMessage();
            System.out.println(logMsg);
        }
    }
}
