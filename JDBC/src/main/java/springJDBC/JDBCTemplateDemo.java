package springJDBC;

import druid.JDBCPoolUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @description: spring框架（Java EE的灵魂框架）对JDBC进行了封装，提供了一个 "JDBCTemplate对象" 简化了JDBC的开发
 * @author: lianghaohong
 * @date: 2021/10/26
 * @time: 9:08 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class JDBCTemplateDemo {

    public static JdbcTemplate jdbcTemplate;

    static {
        try {
            jdbcTemplate = new JdbcTemplate(JDBCPoolUtils.getDataSource());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询 id为1的记录，将其封装为Map集合, 注意：该方法的结果只能是一条记录，多条记录只能封装成List集合
     */
    public static void queryUser() {
        String sql = "select * from user where id =?";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, 1);
        System.out.println(stringObjectMap);
    }

    /**
     * 查询所有user表记录，将其封装为List集合，其实是将每一条记录封装成一个Map集合，然后将Map集合装载到List集合中
     */
    public static void queryAllUser() {
        String sql = "select * from user";
        List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql);
        // List集合中的每个对象都是一个Map对象
        for (Map<String, Object> map : userList) {
            System.out.println(map);
        }
        System.out.println(userList);
    }

    /**
     * 查询所有的user表记录，每一条记录都封装成一个User对象，然后装载到List集合中（这也是开发中最常用的一种方式）
     * 这是提供好的接口可以让我们自定义对象的封装，如果我们不需要对查询出来的字段做其他操作，也可以直接使用对象的封装
     */
    public static void quertAllUserForBeanList() {
        String sql = "select * from user";
        // 该方法每调用一次就会返回一个User对象
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id")); // 数据库表的列名字段
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });

        System.out.println(userList);
    }

    /**
     * 一般我们用BeanPropertyRowMapper的实现类，也可以完成数据到javaBean的自动封装
     * BeanPropertyRowMapper实现了RowMapper接口，直接放自己定义好的实体类就行。
     */
    public static void quertAllUserForBeanList2() {
        String sql = "select * from user";
        // 刚方法每调用一次就会返回一个User对象
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        System.out.println(userList);
    }


    /**
     * 查询所有user的记录条数，queryForObject一般用于聚合函数的查询
     */
    public static void countAllUser() {
        String sql = "select count(id) from user";
        Long count = jdbcTemplate.queryForObject(sql, Long.class); //这里除了sql参数，后面的类型就是要求返回的数据类型
        System.out.println(count);
    }

    /**
     * 添加一条记录
     */
    public static void insertUser() {
        String sql = "insert into user(username,password) values(?,?)";
        int result = jdbcTemplate.update(sql, "ffff", "12345tt");
        System.out.println("插入结果为：" + result);
    }

    /**
     * 修改一条记录
     */
    public static void updateUser() {
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCPoolUtils.getDataSource());

            // 我们只需要关注sql语句，也不需要获取连接，释放连接
            // 定义sql
            String sql = "update user set username=? where id=? ";
            // 更新数据库中的数据
            int count = jdbcTemplate.update(sql, "hhhhh", 1);
            System.out.println(count);
            // 从上面可以看出我们只需要关注怎么定义sql语句，怎么处理结果

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser() {
        String sql = "delete from user where id =?";
        int result = jdbcTemplate.update(sql, 5);
        if (result == 1)
            System.out.println("删除成功！！");

    }

    public static void main(String[] args) {
        //insertUser();
        //deleteUser();
        //queryUser();
        //queryAllUser();
        quertAllUserForBeanList2();



        //countAllUser();
    }
}
