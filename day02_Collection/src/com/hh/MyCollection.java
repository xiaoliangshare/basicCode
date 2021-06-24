package com.hh;

import java.util.*;
/*
    Collection是父级接口，总共8大共性方法(牢记)
            boolean add(E e) ： 把给定的对象添加到当前集合中 。
            void clear() :清空集合中所有的元素。
            boolean remove(E e) : 把给定的对象在当前集合中删除。
            boolean contains(E e) : 判断当前集合中是否包含给定的对象。
            boolean isEmpty() : 判断当前集合是否为空。
            int size() : 返回集合中元素的个数。
            Object[] toArray() : 把集合中的元素，存储到数组中。
            Iterator<E> iterator()：获取迭代器的方法
*/
public class MyCollection {
    public static void main(String[] args) {
        Collection<String> coll=new ArrayList<>();
        coll.add("LHH");
        coll.add("AAA");
        coll.add("BBB");
        coll.add("CCC");

        coll.remove("BBB");
        System.out.println(coll);
        //coll.clear();
        System.out.println(coll);
        Object[] array = coll.toArray();
        for(Object o:array){
            System.out.println((String)o);
        }

    }
}
//5.for: 直接出现for循环