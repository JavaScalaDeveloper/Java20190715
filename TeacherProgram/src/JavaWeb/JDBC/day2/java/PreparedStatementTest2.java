package JavaWeb.JDBC.day2.java;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

import JavaWeb.JDBC.day2.bean.User;
import JavaWeb.JDBC.day2.util.JDBCUtils;
import org.junit.Test;


/**
 * PreparedStatement解决Statement的弊端
 * 1.解决拼串的问题：参照 课后练习2
 * 2.解决sql注入问题
 */
public class PreparedStatementTest2 {
	public static void main(String[] args) {
		PreparedStatementTest2 p = new PreparedStatementTest2();
		p.testLogin();
	}
	@Test
	public void testLogin() {
		Scanner s = new Scanner(System.in);
		System.out.println("用户名：");
		String user = s.nextLine();

		System.out.println("密码：");
		String password = s.nextLine();
		// select user,password from user_table where user = '' and password = '';
		//select user,password from user_table where user = '1' or ' and password = ' = '1' or '1' = '1';
		String sql = "SELECT user,password FROM user_table WHERE USER = ? AND PASSWORD = ?";

		User u = getInstance(User.class,sql,user,password);
		if (u != null) {
			System.out.println("登录成功");
		} else {
			System.out.println("登录失败");
		}

	}

	// 通用的查询，返回一条记录
	public <T> T getInstance(Class<T> clazz, String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.获取连接
			conn = JDBCUtils.getConnection();
			// 2.预编译sql语句
			ps = conn.prepareStatement(sql);

			// 3.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			// 4.调用executeQuery()，获取结果集
			rs = ps.executeQuery();

			// 5.获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// 6.获取结果集中列的个数
			int columnCount = rsmd.getColumnCount();

			// 7.处理结果集
			if (rs.next()) {// ①判断指针的下一个位置是否有数据 ②如果返回true,指针下移。如果返回false,指针不下移。

				T t = clazz.newInstance();

				for (int i = 0; i < columnCount; i++) {// 处理列

					Object columnValue = rs.getObject(i + 1);// 获取列值

					String columnLabel = rsmd.getColumnLabel(i + 1);// 获取结果集中列的别名

					// 反射
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);

				}

				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 8.关闭资源
			JDBCUtils.closeResource(conn, ps, rs);

		}

		return null;
	}
}
