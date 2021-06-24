package com.hh;

import java.util.Calendar;
import java.util.Date;

/*
      Canlendar：日历类，里面提供了很多操作日历字段的方法
                 它是一个抽象类，但是可以通过getInstance()返回该类的一个子类对象
                 get()
                 set()
                 add()
                 getTime()
*/
public class MyCalendar {
    public static void main(String[] args) {
        getDate();
        setDate();
        addDate();
        getTimeDate();
    }

    //Calendar类的get()，获取年其实可以直接用Calendar.成员
    public static void getDate(){
        Calendar c = Calendar.getInstance(); //多态
        System.out.println(c);

        //获取年月日时分秒
        int year = c.get(Calendar.YEAR); //获取年
        System.out.println("年："+year);

        int month = c.get(Calendar.MONTH)+1;//西方的月是0-11，我们是1-12，所以我们要+1,凡是获取月份就要加1
        System.out.println("月："+month);

        int date = c.get(Calendar.DATE);//获取今天是几号=DAY_OF_MONTH
        System.out.println("日："+date);

        System.out.println("时："+c.get(Calendar.HOUR));  //时
        System.out.println("分："+c.get(Calendar.MINUTE));//分
        System.out.println("秒："+c.get(Calendar.SECOND));//秒
        System.out.println("周："+c.get(Calendar.DAY_OF_WEEK));//当前月的第几周
    }
    //Calendar类的set()
    public static void setDate(){
        Calendar c = Calendar.getInstance(); //多态
        c.set(Calendar.YEAR,2090);//可以分别设置指定的年,月，日
        c.set(8888,8,8);//也可以一起设置
        System.out.println(c.get(Calendar.MONTH)); //这里可以不用加1
    }

    //Calendar类的add()
    public static void addDate(){
        Calendar c = Calendar.getInstance(); //多态
        c.add(Calendar.YEAR,10);
        //c.add(Calendar.MONTH,2);
        System.out.println("增加之后的年："+c.get(Calendar.YEAR));
        System.out.println("增加之后的月："+(c.get(Calendar.MONTH)+1));
    }
    public static void getTimeDate(){
        Calendar c = Calendar.getInstance();
        Date date = c.getTime(); //作用相当于new Date()
        System.out.println(date);//Sat Dec 19 23:26:40 CST 2020



    }
}
