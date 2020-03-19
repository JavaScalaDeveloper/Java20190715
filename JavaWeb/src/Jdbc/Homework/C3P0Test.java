/*
package Jdbc.Homework;

import Jdbc.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

*/
/**
 * @author 黄佳豪
 * @create 2019-08-04-20:13
 *//*

public class C3P0Test {
    //方式二：使用配置文件
    @Test
    public void testConnection2() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
    //方式一：代码获取连接
    @Test
    public void testConnection1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        cpds.setUser("root");
        cpds.setPassword("abc123");
        System.out.println(cpds.getConnection());
        cpds.close();//测试的时候关闭
    }
}
*/
