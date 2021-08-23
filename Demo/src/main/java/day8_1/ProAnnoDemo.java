package day8_1;

/**
 * @description: 使用注解案例
 * @author: lianghaohong
 * @date: 2021/8/3
 * @time: 11:13 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Pro(className = "User",methodName = "show")
public class ProAnnoDemo {
    public static void main(String[] args) {
        /**
         *  需求：不能改变该类的任何代码，可以去创建任意类的对象，可以执行任意方法
         */

        /**
         * 1、获取指定位置的注解对象（Class，Method，Field）, 其实就是在内存中生成了一个该注解接口的子类实现对象，并实现了接口中的方法，如下：
         *  public class ProImpl implements Pro{
         *      public String className(){
         *          return "使用注解的时候配置的啥，这里就返回啥";
         *      }
         *
         *      public String methodName(){
         *          return "使用注解的时候配置的啥，这里就返回啥";
         *      }
         *  }
         */
        Pro pro = ProAnnoDemo.class.getAnnotation(Pro.class);
        //2、调用注解中定义的抽象方法，获取返回值
        String className = pro.className();
        String methodName = pro.methodName();
        System.out.println(className);
        System.out.println(methodName);

        //因此注解可以实现和使用Properties加载配置文件相同的功能


    }
}
