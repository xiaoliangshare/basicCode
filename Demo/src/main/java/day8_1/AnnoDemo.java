package day8_1;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 注解javadoc演示
 * @author: lianghaohong
 * @date: 2021/8/1
 * @time: 11:22 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@SuppressWarnings(value = "all")
//使用自定义注解必须对注解里面的方法进行赋值，如果不赋值就要给默认值
//如果有两个属性需要赋值，则value需要显示加上
@MyAnoo(age = 1, value = "12", myann2 = @MyAnno2,strs = {"abc","bbb"})
public class AnnoDemo {
    /**
     * @param a
     * @param b
     * @return 连个int类型数字之和
     */
    public int add(int a, int b) {
        return a + b;
    }

    @Override //重写父类的方法
    public String toString() {
        return super.toString();
    }

    /**
     * show1属于低版本方法，不建议使用，但为了兼容低版本可以用@Deprecated注解
     */
    @Deprecated
    public void show1() {
        //有缺陷
    }


    @MyAnoo
    public void show2() {
        show1();
    }


}
