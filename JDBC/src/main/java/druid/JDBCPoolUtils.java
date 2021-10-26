package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @description: 有了连接池技术之后，连接池也只需要一个，我们就可以改造无连接池的工具类
 * @author: lianghaohong
 * @date: 2021/10/25
 * @time: 7:46 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class JDBCPoolUtils {

    // 定义成员变量
    private static DataSource dataSource;
    private static Properties properties = new Properties();

    static {
        try {
            InputStream resourceAsStream = JDBCPoolUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);

            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        if (dataSource == null) {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }
        return dataSource.getConnection();
    }

    /**
     * 重载释放资源, 增删改
     */
    public static void close(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 重载释放资源, 查询
     */
    public static void close(Statement statement, Connection connection, ResultSet resultSet) {
        close(statement, connection);
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池的方法, 也可直接返回，但是我们这里最好保证一下返回值不为空
     */
    public static DataSource getDataSource() throws Exception {
        if (dataSource == null) {
            return DruidDataSourceFactory.createDataSource(properties);
        }
        return dataSource;
    }
}
