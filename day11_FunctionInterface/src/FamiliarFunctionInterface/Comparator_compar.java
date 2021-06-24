package FamiliarFunctionInterface;

import java.util.Arrays;
import java.util.Comparator;

/*
      java.util.Comparator<T> 也是一个函数式接口
            int compare(T o1, T o2); ：自定义比较规则的方法

      如果一个方法的返回值类型是一个函数式接口，那么就直接返回一个Lambda表达式
      也是函数式接口的第二种使用方式：
          2、作为方法的返回值类型: Interface inter=show()，return ()->{};
          其他的函数式接口都是用作方法的参数来用
*/
public class Comparator_compar {
    public static void main(String[] args) {
        String[] arr={"aafwefw","aaa","fgew","fffffffff"};
        Arrays.sort(arr,getComparator());
    }

    //定义一个方法，方法的返回值类型是一个函数式接口Comparator,我们返回这个接口的匿名实现类对象
    public static Comparator<String> getComparator(){
        //普通式返回
        /*return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };*/
        //Lambda式返回
        return (o1,o2)->o1.length()-o2.length();
    }
}
