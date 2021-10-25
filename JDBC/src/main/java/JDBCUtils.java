import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @description: 对于Utils工具类里面的方法一般都使用 public static 来修饰以便于外部直接用类名直接调用
 * @author: lianghaohong
 * @date: 2021/10/23
 * @time: 10:29 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class JDBCUtils {
    //这里为什么是static是因为我们的static代码块需要对下面三个参数进行赋值操作，如果是非static，下面的static代码块是访问不了的
    //非static可以访问static，因为static先存在，但是static只能访问static
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        //读取配置文件，获取值
        try {
            Properties properties = new Properties();
            // 获取src路径下文件的方式--》ClassLoader()
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("src/jdbc.properties");
            properties.load(resourceAsStream);

            //----另外一种方式
            URL resource = JDBCUtils.class.getClassLoader().getResource("src/jdbc.properties");
            String path = resource.getPath();
            properties.load(new FileReader(path));


            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            // 注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接对象的方法，获取连接可以传递参数，但是传递参数太麻烦，在调用的时候依然是需要写参数，还不如抽取
     * 解决：我们使用配置文件的形式就可以拿到对应的参数(非常常用，必须要回)，如果需要改变连接的数据库，只需修改配置文件
     *
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 资源释放，增删改
     * ps：不能直接将两个资源的释放放在一个try里面，必须分开抓取，如果第一个资源关闭出现异常，则直接调转到catch语句，第二个资源不会被关闭导致资源的浪费
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
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 资源释放，查询
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
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
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
