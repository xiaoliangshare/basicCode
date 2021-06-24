package com.hh;
import java.util.ArrayList;
import java.util.Iterator;

/*
        泛型的通配符：？ 它代表任意的数据类型
        使用方式： 不能创建对象使用；只能作为方法的参数使用

 */
public class MyGeneric2 {
    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<>();// List<Integer> list =new ArrayList<>();下面居然会报错
        list.add(1);
        list.add(2);

        ArrayList<String> list2 =new ArrayList<>();
        list2.add("A");
        list2.add("B");

        printArray(list);
        printArray(list2);

        //ArrayList<?> list3 =new ArrayList<?>(); 这句话会报错，所以不能在创建对象的时候使用通配符
    }
    /*  需求：
            定义一个方法，能遍历所有类型的ArrayList集合，
            这时我们不知道ArrayList集合使用的是什么数据类型，这时就用通配符
     */
    public static void printArray(ArrayList<?> list){
        Iterator<?> it = list.iterator();
        while (it.hasNext()){
            Object e = it.next();//通配符取出的就是Object类型
            System.out.println(e);
        }
    }
}
