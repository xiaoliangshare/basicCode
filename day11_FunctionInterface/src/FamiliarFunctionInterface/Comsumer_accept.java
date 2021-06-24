package FamiliarFunctionInterface;

import java.util.function.Consumer;

/*
       java.util.function.Consumer<T> 也是一个函数式接口，接口则正好与Supplier接口相反，它不是生产一个数据，而是消费一个数据， 其数据类型由泛型决定
            void accept(T t)：意为消费一个指定泛型的数据，泛型执行什么类型，就可以使用accept() 方法消费什么类型的数据

*/
public class Comsumer_accept {
    //定义一个方法消费一个String类型的数据
    //                        String                    String
    public static void method(String foodname, Consumer<String> consumer){//这里的method方法类似于那个create()
        consumer.accept(foodname);
    }

    public static void main(String[] args) {
        //普通式调用
        method("汉堡", new Consumer<String>() {
            @Override
            public void accept(String foodname) {
                //这个消费其实就是对T类型的数据进行一些操作，至于里面的方法体可以任意
                System.out.println("LHH今天吃了一个"+foodname);
            }
        });

        //Lambda式调用,
        method("炸鸡",(String foodname)->{
            System.out.println("BB今天吃了一个"+foodname);
        });
    }
}
