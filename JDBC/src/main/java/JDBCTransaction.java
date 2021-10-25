import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description: 使用JDBC实现事务管理, 模拟张三给李四转钱
 * @author: lianghaohong
 * @date: 2021/10/25
 * @time: 3:23 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class JDBCTransaction {

    public static void transferAccount() {
        Connection connection = null;
        PreparedStatement pstm1 = null;
        PreparedStatement pstm2 = null;

        try {
            // 获取连接
            connection = JDBCUtils.getConnection();

            // 此时就需要用到connection对象的事务管理对象,在执行操作之前开启事务
            connection.setAutoCommit(false);
            //定义sql
            String sql1 = "update account set amount = amount - ? where id = ?";
            String sql2 = "update account set amount = amount + ? where id = ?";

            // 获取执行sql的对象
            pstm1 = connection.prepareStatement(sql1);
            pstm2 = connection.prepareStatement(sql2);

            //给参数进行设置值
            pstm1.setDouble(1, 500);
            pstm1.setInt(2, 1);
            pstm2.setDouble(1, 500);
            pstm2.setInt(2, 2);

            int i = pstm1.executeUpdate();

            // 模拟转账出错, 这里就需要用事务来管理了
            int error = 1 / 0;

            int j = pstm2.executeUpdate();

            // 业务操作执行完之后进行事务的提交
            connection.commit();
        } catch (SQLException e) {
            // 只要出现任何异常都需要进行事务回滚
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstm1, connection);
            JDBCUtils.close(pstm2, null);
        }

    }

    public static void main(String[] args) {
        /**
         * 事务就是一组不可分割的逻辑操作，要么都执行成功，要么都不执行成功
         * 要点就是弄明白事务开启，提交和回滚的使用位置
         */

    }

}
