package reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/11/17
 * @time: 7:31 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class ParameterDemo {
    public void test(Person person, String value) {
    }

    public static void main(String[] args) throws Exception {
        Method method = ParameterDemo.class.getMethod("test", Person.class, String.class);
        // 前置工作：先要获取具体的service
        Class<?>[] parameterTypes = method.getParameterTypes();
        System.out.println("parameterTypes[0].getName():" + parameterTypes[0].getName());
        Class<?> personClass = Class.forName(parameterTypes[0].getName());
        Object o = personClass.newInstance();
        personClass.getField("");


        Parameter[] parameters = method.getParameters();
        Class<?> aClass = Class.forName(parameters[0].getType().getName());
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
