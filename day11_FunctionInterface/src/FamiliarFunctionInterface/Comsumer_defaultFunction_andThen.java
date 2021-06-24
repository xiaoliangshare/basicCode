package FamiliarFunctionInterface;

import java.util.function.Consumer;

/*
       Consumer接口的default方法andThen(): 他底层调用的还是accept()
            作用：需要两个Consumer接口，可以把两个Consumer组合到一起，再对数据进行消费
       例子：
            Consumer<String> con1;
            Consumer<String> con2;
            String s="hello";
            con1.accept(s);
            con2.accept(s);
            等价与：con1.andThen(con2).accept(s);
*/
public class Comsumer_defaultFunction_andThen {
     //方法的参数传递一个字符串和两个Consumer接口
    public static void method(String foodname, Consumer<String> con1,Consumer<String> con2){
        con1.accept(foodname);
        con2.accept(foodname);

        //使用andThen方法,con1在前面，他先消费，con2后消费
        //如果有多个Consumer接口，例如3个：con1.andThen(con2).andThen(con3).accept(foodname);
        con1.andThen(con2).accept(foodname);
    }

    public static void main(String[] args) {
        method("汉堡", new Consumer<String>() {
            @Override
            public void accept(String foodname) {
                System.out.println("LHH今天吃了一个"+foodname);
            }
        }, new Consumer<String>() {
            @Override
            public void accept(String foodname) {
                System.out.println("LHH今天又吃了一个"+foodname);
            }
        });

        //Lambda式调用
        method("汉堡",(String foodname)->{
            System.out.println("LHH今天吃了一个"+foodname);
        },(String foodname)->{
            System.out.println("LHH今天吃又了一个"+foodname);
        });
    }
}
