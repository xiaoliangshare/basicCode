import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @description: 模拟用户登陆
 * @author: lianghaohong
 * @date: 2021/10/25
 * @time: 1:05 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */

public class JDBCLogin {
    /**
     * 登陆方法，使用preparedStatement来实现
     */
    public static boolean login(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // 异常流先走
        if (username == null && password == null) {
            return false;
        }

        // 连接数据库去查询
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select username, password from user where username=? and password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);//给第一个？赋值
            preparedStatement.setString(2,password);//给第二个？赋值
            resultSet = preparedStatement.executeQuery();
            // 只要查到就返回true，没有就是false
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        // 模拟登陆
        boolean isLogin = login(username, password);
        if (isLogin) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("用户名/密码错误，登陆失败！！");
        }
    }
}
