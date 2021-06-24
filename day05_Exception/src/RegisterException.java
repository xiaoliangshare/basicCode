
/*
      自定义异常类：java提供的异常类，不够我们使用，就需要自己定义一些异常类
            1. 自定义一个编译期异常类: 自定义类 并继承于 java.lang.Exception 。
            2. 自定义一个运行期异常类:自定义类 并继承于 java.lang.RuntimeException 。
      注意：自定义异常类一般都是Exception结尾，说明该类是一个异常类
      使用格式：
            public calss xxxException extends Exception | RuntimeException{
                   两件事：1、添加一个空参数的构造方法
                          2、添加一个带异常信息的构造方法
            }
*/
public class RegisterException extends Exception{
    //空参构造方法
    public RegisterException(){}

    //带参构造方法,源码都是直接调用父类带异常信息的构造方法，让父类来处理这个异常信息，我们也这样做
    public RegisterException(String message){
         super(message);
    }


}
