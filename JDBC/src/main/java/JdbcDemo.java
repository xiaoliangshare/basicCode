import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 修改account表中的某条记录
     */
    public static void updateAccount() {
        Connection collection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            collection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345678");
            String sql = "update account set amount=1000 where id=1";
            preparedStatement = collection.prepareStatement(sql);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (collection != null) {
                try {
                    collection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }


    /**
     * 查询表记录
     */
    public static void selectAccount() {
        Connection collection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            collection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345678");
            String sql = "select * from account";
            preparedStatement = collection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            // 处理结果,让游标向下移动一行
            resultSet.next();
            int id = resultSet.getInt(1);
            String username = resultSet.getString("username");
            BigDecimal amount = resultSet.getBigDecimal("amount");
            System.out.println(id + "---" + username + "---" + amount);

            // 正确写法, 如果是true则为数据行，如果是false则为行末尾
            // 获取某列的数据值都统一用  数据库表中列的名称
            while (resultSet.next()) {
                System.out.println("id:" + resultSet.getInt("id") + "username:" + resultSet.getString("username") + "amount:" + resultSet.getBigDecimal("amount"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (collection != null) {
                try {
                    collection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }


    /**
     * 查找所有的emp表并封装为List对象集合
     *
     * @return
     */
    public static List<Emp> finAll() {
        Connection collection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Emp> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            collection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345678");
            String sql = "select * from account";
            preparedStatement = collection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            // 正确写法, 如果是true则为数据行，如果是false则为行末尾
            // 获取某列的数据值都统一用列的名称
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                BigDecimal amount = resultSet.getBigDecimal("amount");
                Emp emp = new Emp();
                emp.setId(id);
                emp.setUsername(username);
                emp.setAmount(amount);
                list.add(emp);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (collection != null) {
                try {
                    collection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }


    public static List<Emp> finAll2() {
        Connection collection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Emp> list = new ArrayList<>();
        try {
            JDBCUtils.getConnection();
            String sql = "select * from account";
            preparedStatement = collection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            // 正确写法, 如果是true则为数据行，如果是false则为行末尾
            // 获取某列的数据值都统一用列的名称
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                BigDecimal amount = resultSet.getBigDecimal("amount");
                Emp emp = new Emp();
                emp.setId(id);
                emp.setUsername(username);
                emp.setAmount(amount);
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(collection, preparedStatement, resultSet);
        }
        return list;
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

/**
 * 我们可以发现每一次都要注册驱动，获取连接，释放资源的操作
 * 我们可以抽取一个工具类：JDBCUtils
 */