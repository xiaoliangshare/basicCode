package com.hh;

import java.util.ArrayList;
import java.util.List;

/*
      JDK 1.5之后可以自动装拆箱
     Integer
            装箱：new Integer(参数)
                  Integer.valueOf(参数)

            拆箱：num.intValue()
*/
public class MyInteger {
    public static void main(String[] args) {
        Integer a=127; //这其实就是自动装箱
        Integer b=127;
        Integer c=200;
        Integer d=200;
        System.out.println(a==b);//true, 常量池技术[-128,127]
        System.out.println(c==d);//false
        System.out.println(a);

        //ArrayList是不能直接存储整数的
        List<Integer> list=new ArrayList<>();
        list.add(1);// 自动装箱: list.add(new Integer(1))
        int num=list.get(0);//自动拆箱： list.get(0).intValue()
    }

     public static void zhuang(){
        Integer a = new Integer("100"); //通过构造方法装箱
        Integer b = Integer.valueOf("100");//通过方法valueOf()装箱，
    }
    public static void chai(){
        Integer a = new Integer("100");
        int i = a.intValue();
    }

}
