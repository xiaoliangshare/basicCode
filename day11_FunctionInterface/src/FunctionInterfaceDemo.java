
/*
        函数式接口的使用：
            1、作为方法的参数: show(Interface inter),而Lambda就是调用show方法时传递的实际参数：show(()->{})
            2、作为方法的返回值类型: Interface inter=show()，return ()->{};
            注意：使用Lambda的前提是必须是函数式接口，否则推断不出要执行接口中的哪个抽象函数。
        记：以后函数式接口和Lambda配套使用
*/
public class FunctionInterfaceDemo {
    public static void main(String[] args) {

        //调用show方法，使用普通的接口实现类对象
        show(new MyFunctionInterfaceImpl());

        //调用show方法，不用创建接口实现类，直接传匿名内部类
        show(new MyFunctionInterface() {
            @Override
            public void method() {
                //这里就写我具体实现这个接口需要干哪些事情
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        /*
            调用show方法，方法的参数是一个函数式接口，所以我们可以用Lambda表达式
            Lambda是匿名内部类的"语法糖",其实就是作用和原理一样，但是性能更高。
         */
        show(()->{
            System.out.println("使用Lambda表达式重写接口中的抽象方法");
        });

        //Lambda简化
        show(()-> System.out.println("使用简化版本Lambda表达式重写接口中的抽象方法"));
    }

    //定义一个方法，参数使用函数式接口（面向接口编程：new一个接口实现类对象，然后用接口来接收）
    public static void show(MyFunctionInterface myFunctionInterface){
        myFunctionInterface.method();
    }
}
