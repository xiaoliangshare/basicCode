package com.hh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
*  DateFormat是日期格式化的抽象类，作用：格式化日期
*       成员方法：
*               String format(Date date)：将日期转化为指定格式的日期字符串
*               Date parse(String source)：将日期字符串转化为日期
*
* 由于DateFormat是抽象类，所以我们都用它的子类SimpleDateFormat
*       构造方法：SimpleDateFormat(String pattern) 例如："yyyy-MM-dd HH:mm:ss" or "yyyy年MM月dd日 HH时mm分ss秒"
*/
public class MyDateFormat {
    public static void main(String[] args) throws ParseException {
        //Date-->String
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format);
        System.out.println(new Date().toLocaleString());//这和上面的结果是一致的，不过现在已经弃用了


        //String-->Date
        /*
            注意DateFormat类的parse() 抛出了一个异常：Date parse(String source) throws ParseException，主要是为了避免传入的参数与pattern模式不一样
            解决办法：
                    用try-catch处理(推荐用)/继续抛出异常让JVM去处理
        */
        Date date = null;
        try {
            date = sdf.parse("2020-12-19 16:48:58");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);//Sat Dec 19 16:48:58 CST 2020
        countDay();
    }

    //计算一个人活了多少天
    public static void countDay() throws ParseException {
         /*
          计算一个人已经出生了多少天？
              1.用Scanner类中的next()获取出生日期
              2.使用DateFormat类中的parse()解析成Date类型
              3.把Date日期转化为毫秒值
              4.获取当前的毫秒值，转化为毫秒值
              5.这两个毫秒值相减再格式化转化为天(s/1000/60/60/24)
       */
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您的出生日期,格式为yyyy-MM-dd：");
        String birthdayStr = input.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = sdf.parse(birthdayStr);
        long birthdayDateTime = birthdayDate.getTime(); //这是出生日期的毫秒值
        long currentTime = System.currentTimeMillis();//当前日期的毫秒值
        long devTime = currentTime - birthdayDateTime;
        System.out.println(devTime / 1000 / 60 / 60 / 24);
    }
}
