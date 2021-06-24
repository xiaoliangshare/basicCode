package Lambda;
/*
      使用Lambda表达式创建线程，它就是为了简化匿名内部类的重写方法
      格式：
           (参数列表) -> {
                重写方法的代码
           }
           (): 接口中抽象方法的参数列表，没有参数则空着，有参数就写出参数，并用逗号隔开
           ->: 传递的意思，把参数传递给方法体{}
           {}: 重写接口中抽象方法的方法体
*/
public class LambdaDemo {
    public static void main(String[] args) {
         new Thread(
                 new Runnable() {
                     @Override
                     public void run() {
                         System.out.println("新线程创建了");
                     }
                 }
         ).start();

         //规范式的Lambda表达式
         new Thread(
                 ()->{
                     System.out.println("Lambda新线程创建了");
                 }
         ).start();

         //省略式的Lambda表达式
        new Thread(
                ()->System.out.println("Lambda省略式的新线程创建了")
        ).start();
    }
}
/*
  在Lambda标准格式的基础上，使用省略写法的规则为：
          1. 小括号内参数的类型可以省略；
          2. 如果小括号内有且仅有一个参，则类型和小括号都可以省略；
          3. 如果大括号内有且仅有一个语句，则无论是否有返回值，都可以省略大括号、return关键字及语句分号。
*/