package Jdbc.DBConnectionPool;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 黄佳豪
 * @create 2019-08-04-16:01
 */
public class DBCPTest {
    /**
     * 方式二
     */
    @Test
    public void testGetConnection2() throws Exception {
        Properties pros = new Properties();
        //方式一
//        FileInputStream is = new FileInputStream("src/dbcp.properties");
        //方式二:使用类的加载器
        InputStream is = DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
        pros.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }
    /**
     * 方式一
     * @throws SQLException
     */
    @Test
    public void testGetConnection1() throws SQLException {
        BasicDataSource source=new BasicDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setUsername("root");
        source.setPassword("abc123");
        source.setInitialSize(10);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }
}
