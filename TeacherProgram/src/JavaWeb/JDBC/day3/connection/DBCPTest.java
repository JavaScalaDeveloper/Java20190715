package JavaWeb.JDBC.day3.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

/**
 * 使用DBCP数据库连接池技术实现数据库连接
 * @author Administrator
 *
 */
public class DBCPTest {
	
	//方式二：使用配置文件
	@Test
	public void testGetConnection2() throws Exception {
		Properties pros = new Properties();
		//方式1：
//		FileInputStream is = new FileInputStream("src/dbcp.properties");
		//方式2：
		InputStream is = DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
		
		pros.load(is);
		
		DataSource source = BasicDataSourceFactory.createDataSource(pros);
		
		Connection conn = source.getConnection();
		System.out.println(conn);
	}
	
	//方式一：
	@Test
	public void testGetConnection1() throws SQLException {
		BasicDataSource source = new BasicDataSource();
		
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/test");
		source.setUsername("root");
		source.setPassword("abc123");
		
		//
		source.setInitialSize(10);
		//...
		
		Connection conn = source.getConnection();
		System.out.println(conn);
	}
	
}
