import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/10/22
 * @time: 3:54 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        // 1、添加mysql的驱动jar包，右键模块--新减一个文件夹--add as Library

        // 2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 3、获取数据库的连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");

        // 4、定义sql语句
        String sql="update account set amount = 500 where id =1";

        // 5、获取执行sql的对象 Statement
        Statement statement = connection.createStatement();

        //6、执行sql
        int count = statement.executeUpdate(sql);

        // 7、处理结果
        System.out.println(count);

        //8、释放资源
        statement.close();
        connection.close();

    }
}
