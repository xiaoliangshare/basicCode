package com.hh;

import java.util.Objects;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        System.out.println("LHH,LHH");
        Scanner input = new Scanner(System.in);
        Person p=new Person("LHH",24);
        Person p1=new Person("LHH",24);

        System.out.println("p.equals(p1):"+p.equals(p1)); //重写之后就是比较对象的内容了

        System.out.println(p.toString());
        System.out.println(p); //p.toString()和p是一样的，都是返回当前对象的地址：com.hh.Person@6e0be858，重写toString()之后则返回对象内容

        String s1=null;
        String s2="abc";
        System.out.println(s1.equals(s2));//会报java.lang.NullPointerException异常
        System.out.println("用Objects工具类里面的equals():"+Objects.equals(s1,s2)); //Objects的equals()也是比较对象内容，但是它可以防止空指针异常,以后推荐都用它






    }
}
//alt+shift+上下箭头：上下移动代码
//alt+Ins: Constructor(),toString(),get(),set()方法
//ctrl+alt+L: 格式化代码
//alt+enter: 导包、添加返回值类型
