
/*
        可变参数：JDK 1.5之后出现的新特性
        使用前提：
                当方法的参数列表数据类型已经确定，但是参数个数不确定就可以使用可变参数，
                格式：修饰符 返回值类型 方法名(参数类型... 形参名){ }，可变参数的底层原理就是一个数组，根据传递参数的
                      个数不同，会创建不同长度的数组来存储这些参数。
                      其实这个书写完全等价于：修饰符 返回值类型 方法名(参数类型[] 形参名){ }，只是调用不同。

                注意：1、一个方法的参数列表，只能有一个可变参数
                      2、如果在方法书写时，这个方法拥有多参数，参数中包含可变参数，可变参数一定要写在参数列表的末尾位置。
                         例如： public static void method(String s,int... arr){}
*/
public class VariableParameters {
    public static void getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void getSum2(int... arr) {
        System.out.println(arr);//[I@1540e19d  这是一个数组地址，所以可变参数就是一个数组
        System.out.println(arr.length);
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println(sum);
    }

    //可变参数的终极写法
    public static void method(Object... obj){

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        getSum(arr);
        getSum2(1,2,3,4,5);
        method("s",12,1.2);
    }
}
