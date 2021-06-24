package com.hh;

/*
    总结下:
            String：适用于少量的字符串操作的情况
            StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
            StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况
            速度：StringBuilder>StringBuffer>String

                append(参数):  参数可以是任意数据类型, 并返回当前对象自身
                               Java中+对字符串的拼接，其实现原理是使用StringBuilder.append()
*/
public class MyString {
    public static void main(String[] args) {
        String s="a";
        String s1="a";
        System.out.println(s==s1);
        StringBuilder sb=new StringBuilder();
        StringBuilder sb2 = sb.append(2);
        System.out.println(sb==sb2);//所以说你可以append()之后无须再接收对象

        sb.append(true).append('中').append("abc");//可以连续append()
        System.out.println(sb);

        //通过toString()，StringBuilder对象将会转换为不可变的String对象
        String sbStr = sb.toString();
        System.out.println(sbStr);



    }
}
