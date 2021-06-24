package Lambda.CalculatorPractice;
/*
     需求：
         给定一个计算器 Calculator 接口，内含抽象方法 add 可以将两个int数字相加得到和值：
*/
public class TestCalculator {
    public static void main(String[] args) {
        calc(1, 2, new Calculator() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        });

        //使用Lambda简化
        calc(10,20,(int a,int b)->{
            return a+b;
        });
    }


    //定义一个计算两个数字相加的方法
    public static void calc(int a,int b,Calculator calculator){
        int result = calculator.add(a, b);
        System.out.println(result);
    }
}
