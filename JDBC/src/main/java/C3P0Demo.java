import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description: C3P0连接池技术的使用, 必须导入两个jar包：c3p0-0.9.5.2.jar、mchange-commons-java-0.2.12.jar，但是也要导入mysql的驱动jar包
 * 因为连接池技术连接的依然是mysql，所以数据库的驱动jar包不能忘记了
 * @author: lianghaohong
 * @date: 2021/10/25
 * @time: 4:54 下午
 * Copyright (C) 2021 Meituan All rights reserved
 */
public class C3P0Demo {
    public static void main(String[] args) {
        // 使用默认的配置，使用最多的还是空参的配置
        DataSource ds = new ComboPooledDataSource();

        // 也可以使用自定义的配置,一般情况下我们使用默认情况就OK
        DataSource otherDs = new ComboPooledDataSource("otherc3p0");

        try {
            Connection connection = ds.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
