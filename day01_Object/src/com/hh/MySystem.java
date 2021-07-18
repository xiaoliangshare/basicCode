package com.hh;

import java.util.Arrays;

/*
        System是lang包下面的一个final类
                System.currentTimeMillis()
                arraycopy(Object src, int  srcPos, Object dest, int destPos, int length)
*/
public class MySystem {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();//获取系统的当前时间(毫秒值)
        for (int i = 0; i < 9999; i++) {
            System.out.println(i);
        }
        long end=System.currentTimeMillis();
        System.out.println("打印0-9999所耗的时间为："+(end-start)+"(毫秒)");
        copyArray();
    }

    //arraycopy()将数组中指定的数据拷贝到另一个数组中,数组的拷贝动作是系统级的，性能很高
    public static void copyArray(){
        int[] srcArr={1,2,3,4,5};
        //int[] destArr={6,7,8,9,10};
        int[] destArr=new int[10];
        System.arraycopy(srcArr,0,destArr,2,5);//部分拷贝数组,从任意位置开始拷贝
        for(int i: destArr){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] newArr = Arrays.copyOf(srcArr, 10);//完全拷贝并缩（扩）容，当然是从0位置开始拷贝
        for(int i: newArr){
            System.out.print(i+" ");
        }
    }
}
