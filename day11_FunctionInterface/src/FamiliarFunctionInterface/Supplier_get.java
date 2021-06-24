package FamiliarFunctionInterface;

import java.util.function.Supplier;

/*
    java.util.function.Supplier<T>也是一个函数式接口
         T get(): 用来获取一个泛型参数指定类型的对象数据
*/
public class Supplier_get {
    public static void main(String[] args) {
        //普通式调用
        String s = getString(new Supplier<String>() {
            @Override
            public String get() {
                return "getString";
            }
        });
        System.out.println(s);
        //Lambda式调用
        String s1 = getString(() -> "我是Supplier函数式接口");
        System.out.println(s1);


        //-----------练习---------
        int[] arr={12,-43,54,2,58,23};
        //普通式调用
        int max = getMax(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int max = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }
                return max;
            }
        });
        //Lambda式调用
        int max2 = getMax(() -> {
            int max1 = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max1 = arr[i];
                }
            }
            return max1;
        });
        System.out.println("数组中最大的数为："+max);
    }



    //定义一个方法，方法的参数传递Supplier<T>接口，泛型指定为T类型，get()就会返回一个T类型的数据
    //            String                   <String>是对应的
    public static String getString(Supplier<String> supplier){
        return supplier.get();
    }

    //练习：求一个int数组中的最大值
    public static int getMax(Supplier<Integer> supplier){
        return supplier.get();
    }
}
