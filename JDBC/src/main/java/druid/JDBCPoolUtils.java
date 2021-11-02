package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
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

            // 这也是一种加载方式
//            URL resource = JDBCPoolUtils.class.getClassLoader().getResource("druid.properties");
//            String path = resource.getPath();
//            properties.load(new FileReader(path));

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
                // 由于该连接是从数据库连接池中拿出来的，该close()并没有真正关闭连接，而是将连接归还到连接池，池技术对close()做了增强，之所以也叫close(),是为了满足开发者的编程习惯
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
