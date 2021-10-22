import java.sql.*;

/**
 * @description:
 * @author: lianghaohong
 * @date: 2021/10/22
 * @time: 3:54 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class JdbcDemo {
    /**
     * 往account表里面添加一条记录,标准
     */
    public static void insertAccount() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///test");
            String sql = "insert into account values(null,'Lhh',3000)";
            preparedStatement = connection.prepareStatement(sql);
            // 执行sql，返回影响的行数
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("添加成功！！");
            } else {
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 避免空指针异常, 因为可能执行到加载驱动的时候就出现了异常，此时的preparedStatement、connection对象依然为空，如果直接调用close()就会出现异常
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }


    }

    public static void main(String[] args) throws Exception {
        // 1、添加mysql的驱动jar包，右键模块--新减一个文件夹--add as Library

        // 2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 3、获取数据库的连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");

        // 4、定义sql语句
        String sql = "update account set amount = 500 where id =1";

        // 5、获取执行sql的对象 Statement
        Statement statement = connection.createStatement();

        // 6、执行sql
        int count = statement.executeUpdate(sql);

        // 7、处理结果
        System.out.println(count);

        //8、释放资源
        statement.close();
        connection.close();
    }
}
