package com.hh;
import java.util.Date;

/*
*  Data日期，它是一个毫秒值，作用就是可以对时间和日期进行计算
*  系统的时间原点是：1970-01-01 00:00:00 (英国格林威治时间)
*      注意：因为我们在东八区，所以我们的时间原点是1970-01-01 08:00:00
*
*      Date带参数的构造方法
*          Date Date(Long date)：把毫秒值转化为日期，每个值都对应一个时间，这个毫秒值就是距离时间原点的差距值
*                                Data(0-999)都是显示：Thu Jan 01 08:00:00 CST 1970
*                                Data(1000)显示： Thu Jan 01 08:00:01 CST 1970
*          Long getTime()：把日期转化为毫秒值
*/
public class MyData {
    public static void main(String[] args) {
        //获取当前系统时间到1970-01-01 08:00:00经历了多少毫秒 （1608365849582L）,Long类型的值 1天=24*60*60=86400秒
        System.out.println(System.currentTimeMillis());//1608365849582
        Date date=new Date(86400000);
        System.out.println(date);//Sat Dec 19 15:47:13 CST 2020

        System.out.println(date.getTime());//86400000


    }
}
