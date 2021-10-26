package druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @description: 测试Druid线程池工具类
 * @author: lianghaohong
 * @date: 2021/10/26
 * @time: 10:14 上午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class DruidDemo2 {

    // 往user表中插入一条记录
    public static boolean saveUser(String name, String pwd) throws Exception {
        // 获取数据库连接
        Connection connection = JDBCPoolUtils.getConnection();
        String sql = "insert into user(username,password) values( ? , ?)";
        // 获取执行sql的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //给sql填充参数
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);

        // 执行sql语句
        int count = preparedStatement.executeUpdate();
        if (count == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        boolean isSaved = saveUser(username, password);
        if (isSaved) {
            System.out.println("插入成功！！");
        } else {
            System.out.println("插入失败！！");
        }

    }
}
