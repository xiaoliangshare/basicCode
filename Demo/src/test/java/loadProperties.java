import day8_1.MyAnoo;
import org.junit.Test;
import reflex.Person;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/8/3
 * @time: 10:07 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class loadProperties {
    @Test
    public void testLoadConfigFile() throws Exception {
        Properties properties = new Properties();
        InputStream is = loadProperties.class.getClassLoader().getResourceAsStream("pro.properties");
        properties.load(is);

        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        System.out.println(className);
        Class userClass = Class.forName(className);
        User user = (User) userClass.newInstance();

        /**
         * 有了注解之后，就可以替代上面加载配置文件的操作
         */
        user.setAge(100);
        user.setUsername("lhh");
        System.out.println(user);


        //调用show方法时没有返回值，为null，如果有返回值都先用Object接受，如果知道具体类型再进行转化
        Method method = userClass.getMethod(methodName);
        MyAnoo myAnoo = method.getAnnotation(MyAnoo.class);

        Person result = (Person) method.invoke(user);
        System.out.println(result.getAge());




    }
}
