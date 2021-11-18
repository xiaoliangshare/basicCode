package reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/11/14
 * @time: 12:56 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class PropertiesRulesAnalysis {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        Person person = new Person();
        Class<Person> personClass = Person.class;
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true); // 暴力反射
        //get 和 set所用的对象要唯一
        name.set(person, "lhh");
        Object o = name.get(person);
        System.out.println(o);

        System.out.println("===============================");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("属性名称：" + field.getName());
            System.out.println("属性类型：" + field.getType());
            System.out.println("属性Modifiers：" + field.getModifiers());
            System.out.println("属性toString()：" + field.toString());//private java.lang.String reflex.Person.name
        }

        System.out.println("===============================");
        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("方法名称：" + method.getName());
            System.out.println("方法Modifiers：" + method.getModifiers());
            System.out.println("方法toGenericString()：" + method.toGenericString());//public void reflex.Person.setName(java.lang.String)
            System.out.println("方法toString()：" + method.toString());//public void reflex.Person.setName(java.lang.String)
        }

        System.out.println("===============================");

        Person person1 = personClass.newInstance();// 必须要有空参构造函数
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor.toString());
        }
        Person person2 = personClass.getConstructor().newInstance(); // 创建对象的第二种方式

        // 对于整数类型，jvm存在常量优化机制，会自动判断该常量是否存在short的
        int i = 2147483647;
        long a = 1;
        Long b = a;
        i = i + 1;
        System.out.println(i);
        long l = 2147483648L;
        short s = 1;
        float f = 1;

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "LHH");
        String s1 = map.get("2");
        System.out.println("key=2:value=" + s1);


        String s2 = "ThriftMaterialBaseService.fuzzyQuery(MaterialFuzzyRequest var1, Paging var2)";
        String[] split = s2.split("ddddd");
        System.out.println("split[0]:"+split[0]);
        if (split.length == 2) {
            System.out.println("split[0]:"+split[0]);
        }

    }
}
