package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/10/25
 * @time: 5:25 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //使用Druid和c3p0有点区别，c3p0的连接池是直接将配置文件放在src根目录下面，然后直接new一个连接池出来，Druid需要加载配置文件

        //1、导入jar包：druid-1.0.9.jar

        //2、定义配置文件，xxx.properties形式
        //3、加载配置文件
        Properties properties = new Properties();
        InputStream resourceAsStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);

        //4、通过DruidDataSourceFactory.createDataSource(properties)来创建数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //5、从池子里拿数据库连接对象
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
        //6、同样归还数据库的连接对象用connection.close();


    }
}
