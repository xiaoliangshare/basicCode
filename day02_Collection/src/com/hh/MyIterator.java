package com.hh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
        Iterator接口：可以对集合进行遍历
                      boolean hasNext(): 如果仍有元素可以迭代，则返回 true
                      E next(): 返回迭代的下一个元素
                      void remove(): 遍历集合的过程中移除元素（重点）

        增强for循环：专门用来遍历数组和集合的(仅遍历用)，它的内部原理其实是个Iterator迭代器，所以在遍历的过程中，不能对集合中的元素进行增删操作
                      for(int i:arr){}
                      for(String str:list){}

*/
public class MyIterator {
    public static void main(String[] args) {
        Collection<String> coll=new ArrayList<>();
        coll.add("LHH");
        coll.add("AAA");
        coll.add("BBB");
        coll.add("CCC");

        //此乃while循环
        Iterator<String> it = coll.iterator();
        while (it.hasNext()){
            String s = it.next();
            if (s.equals("BBB")){
                it.remove();
            }
        }
        System.out.println(coll);



        //下面用for循环(了解就行)
        for (Iterator<String> it2=coll.iterator();it.hasNext();){
            String str=it2.next();
            if (str.equals("BBB")){
                it.remove();
            }
        }
        System.out.println(coll);

    }
}
