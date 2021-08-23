package day8_1;

import java.lang.annotation.*;

/**
 * @description: 描述需要执行的类名和方法名
 * @author: lianghaohong
 * @date: 2021/8/3
 * @time: 11:11 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Pro {
    String className() default "";

    String methodName() default "";
}
