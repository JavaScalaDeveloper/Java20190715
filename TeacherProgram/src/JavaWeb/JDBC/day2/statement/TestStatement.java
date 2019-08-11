package JavaWeb.JDBC.day2.statement;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JavaWeb.JDBC.day2.bean.User;
import JavaWeb.JDBC.day2.util.JDBCUtils;
import org.junit.Test;


public class TestStatement {

	//使用Statement的弊端：① 需要拼写sql语句，②存在SQL注入的问题
	@Test
	public void testLogin() {
		Scanner s =  new Scanner(System.in);
		System.out.println("用户名：");
		String user = s.nextLine();
		
		System.out.println("密码：");
		String password = s.nextLine();
		//select user,password from user_table where user = '' and password = '';
		//select user,password from user_table where user = '1' or ' and password = ' = '1' or '1' = '1';
		String sql = "SELECT user,password FROM user_table WHERE USER = '"+ user +"' AND PASSWORD = '"+ password +"'";
		
		User u = get(sql,User.class);
		if(u != null) {
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
		
	}
	
	public <T> T get(String sql, Class<T> clazz) {// (sql, Customer.class)
		T t = null;

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();

			st = conn.createStatement();

			rs = st.executeQuery(sql);

			// 获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();

			// 获取结果集的列数
			int columnCount = rsmd.getColumnCount();

			if (rs.next()) {

				t = clazz.newInstance();

				for (int i = 0; i < columnCount; i++) {
					// //1. 获取列的名称
					// String columnName = rsmd.getColumnName(i+1);

					// 1. 获取列的别名
					String columnName = rsmd.getColumnLabel(i + 1); // 注意：
																	// 获取结果集中（相当于数据表）列的名称（别名）

					// 2. 根据列名获取对应数据表中的数据
					Object columnVal = rs.getObject(columnName);

					// 3. 将数据表中得到的数据，封装进对象
					Field field = clazz.getDeclaredField(columnName); // 注意：反射根据Java中类的属性获取
																		// Field对象
					field.setAccessible(true);
					field.set(t, columnVal);
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(st != null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}
