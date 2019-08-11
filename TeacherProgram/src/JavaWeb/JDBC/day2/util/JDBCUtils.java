package JavaWeb.JDBC.day2.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 提供数据库连接、关闭等操作的工具类
 * 
 * @author Administrator
 *
 */
public class JDBCUtils {

	// 关闭资源的操作
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 关闭资源的操作
	public static void closeResource(Connection conn, Statement st) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 获取连接的操作
	public static Connection getConnection() throws Exception {
		// 1.加载配置文件
		Properties pros = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Workspaces\\Java20190715\\TeacherProgram\\src\\JavaWeb\\jdbc.properties");
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
