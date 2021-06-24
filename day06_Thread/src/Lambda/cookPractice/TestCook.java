package Lambda.cookPractice;

public class TestCook {
    public static void main(String[] args) {
        //匿名内部类可以帮我们省去实现类的定义；
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("开始吃饭啦！");
            }
        });

        //使用Lambda表达式，简化匿名内部类的书写
        invokeCook(
                ()->{
                    System.out.println("开始吃饭啦！");
                }
        );

    }

    //定义一个方法，参数传递Cook接口，方法内部调用Cook接口中的方法makeFood()
    public static void invokeCook(Cook cook){
        cook.makeFood();
    }
}
