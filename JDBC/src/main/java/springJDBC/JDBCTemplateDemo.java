package springJDBC;

import druid.JDBCPoolUtils;
import org.springframework.jdbc.core.JdbcTemplate;

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
     * 查询所有user表记录，将其封装为Map集合
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
        queryAllUser();
    }
}
