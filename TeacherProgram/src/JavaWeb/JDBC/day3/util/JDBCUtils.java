package JavaWeb.JDBC.day3.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import JavaWeb.JDBC.day3.connection.DBCPTest;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 提供数据库连接、关闭等操作的工具类
 */
public class JDBCUtils {
	/**
	 * 测试main方法
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		Connection conn = getC3P0Connection();
		System.out.println(conn);
	}

	// 关闭资源的操作
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
//		if (conn != null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		if (st != null) {
//			try {
//				st.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
		try {
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			DbUtils.close(st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			DbUtils.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
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
		FileInputStream fis = new FileInputStream("D:\\Workspaces\\Java20190715\\TeacherProgram\\src\\jdbc.properties");
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
	
	//使用c3p0数据库连接池的方式
	private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0"); //保证此数据源是唯一的！
	public static Connection getC3P0Connection() throws SQLException {
		
		Connection conn = cpds.getConnection();
		return conn;
	}
	
	//使用dbcp数据库连接池的方式
	private static DataSource source;//保证此数据源是唯一的！
	static{
		try {
			Properties pros = new Properties();
			InputStream is = DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
			
			pros.load(is);
			
			source = BasicDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getDBCPConnection() throws SQLException {
		
		Connection conn = source.getConnection();
		
		return conn;
	}

}
