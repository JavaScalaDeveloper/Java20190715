package Jdbc.Homework;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 黄佳豪
 * @create 2019-08-04-20:25
 */
public class DBCPTest {
    //方式二：使用配置文件
    @Test
    public void testGetConnection2() throws Exception {
        Properties pros = new Properties();
        InputStream is = DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
        pros.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }
    //方式一
    @Test
    public void testConnection1() throws SQLException {
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setUsername("root");
        source.setPassword("abc123");
        source.setInitialSize(10);
        System.out.println(source.getConnection());
    }
}
