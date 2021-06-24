package FamiliarFunctionInterface;

import java.util.function.Predicate;

/*
       java.util.function.Predicate<T> 接口。
            boolean test(T t): 我们需要对某种类型的数据进行判断，从而得到一个boolean值结果。
*/
public class Predicate_test {
    public static boolean checkString(String s,Predicate<String> predicate){
        return predicate.test(s);
    }

    public static void main(String[] args) {
        String str="aaaaa";
        //普通式调用
        boolean b = checkString(str, new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str instanceof String;
            }
        });
        System.out.println(b);
        //Lambda式调用
        checkString(str,s->s instanceof String);
    }
}
