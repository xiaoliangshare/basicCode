package day8_1;

import java.lang.annotation.*;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/8/1
 * @time: 11:51 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Target(value = {ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})//可以作用于类(接口，enum)、方法、成员变量上
@Retention(value = RetentionPolicy.RUNTIME) //我们定义的注解都用运行阶段
@Documented //加上之后可以在javadoc中抽取出来
@Inherited //该注解是可以被继承的
public @interface MyAnoo {
    /**
     * 注解本质上就是一个接口，该接口默认继承Annocation接口
     *
     *
     * 属性：就是接口中的抽象方法
     *      要求：
     *          属性(方法)的返回值类型只能是：基本数据类型，String，枚举，注解，以上类型的数组
     *
     * 元注解：用于描述注解的注解
     * @Target: 描述注解能够作用的位置
     * @Retention： 描述注解被保留的位置
     * @Document： 描述注解是否能被抽取到API文档中
     * @Inherited： 描述注解是否被子类继承
     *
     */

    int age() default 20;//基本类型

    String name() default "lhh"; //String类型

    Color col() default Color.RED; //枚举类型

    MyAnno2 myann2() default @MyAnno2; //注解类型

    String[] strs() default {};  //以上注解的数组类型

    //特殊属性value,如果注解里面只有value这一个属性，则在使用属性value的时候可以不写，但在使用多个属性时value就要显示写上
    String value() default "";
}
