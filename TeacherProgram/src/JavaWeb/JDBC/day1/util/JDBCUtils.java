package JavaWeb.JDBC.day1.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 提供数据库连接、关闭等操作的工具类
 * 
 * @author Administrator
 *
 */
public class JDBCUtils {
	
	

	public static Connection getConnection() throws Exception {
		// 1.加载配置文件
		Properties pros = new Properties();
		FileInputStream fis = new FileInputStream("src/jdbc.properties");
		pros.load(fis);

		// 2.获取连接所需的四个基本信息
		String driverClass = pros.getProperty("driverClass");
		String url = pros.getProperty("url");
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");

		// 3.加载驱动
		Class.forName(driverClass);

		// 4.获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}

}
