/*
package com.atguigu.connection;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

*/
/**
 * 1.实现数据库连接的方式：
 *  ① 手动实现的连接 （DriverManager)
 *  ② 使用数据库连接池
 *
 * 2.使用数据库连接池的好处：
 *  ① 更快的连接速度
 *  ② 更好的资源重用
 *  ③ 更便捷的数据库连接的管理
 *
 * 3.JDBC 的数据库连接池使用 javax.sql.DataSource 来表示，DataSource 只是一个接口
 *
 * 4. 两种数据库连接池技术：① C3P0 数据库连接池  ② DBCP数据库连接池
 *
 * @author Administrator
 *
 *//*

public class C3P0Test {

    //方式二：使用配置文件
    @Test
    public void testConnection2() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");

        Connection conn = cpds.getConnection();
        System.out.println(conn);

    }

    //方式一：
    @Test
    public void testConnection1() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" );
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
        cpds.setUser("root");
        cpds.setPassword("abc123");

        //
        cpds.setMaxPoolSize(100);

        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }

}
*/
