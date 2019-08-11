package JavaWeb.JDBC.day2.java;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import JavaWeb.JDBC.day2.bean.Customer;
import JavaWeb.JDBC.day2.bean.Order;
import JavaWeb.JDBC.day2.util.JDBCUtils;
import org.junit.Test;


/**
 * 针对于不同的表，使用PreparedStatement实现通过的查询操作
 * @author Administrator

 * 体会： 两种思想：①面向接口编程 ②ORM思想 两种技术：
 * ① 结果集的元数据：ResultSetMetaData ② 反射的技术
 */
public class PreparedStatementTest1 {
	
	@Test
	public void testGetForList() {
		String sql = "select id,name,birth from customers where id < ?";
		List<Customer> list = getForList(Customer.class, sql, 12);
		
		list.forEach(System.out::println);

	}
	// 通用的查询，返回多条记录
	public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<>();
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
			while (rs.next()) {// ①判断指针的下一个位置是否有数据 ②如果返回true,指针下移。如果返回false,指针不下移。
				T t = clazz.newInstance();

				for (int i = 0; i < columnCount; i++) {// 处理列

					Object columnValue = rs.getObject(i + 1);// 获取列值

					String columnLabel = rsmd.getColumnLabel(i + 1);// 获取结果集中列的别名

					// 反射
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);

				}

				list.add(t);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 8.关闭资源
			JDBCUtils.closeResource(conn, ps, rs);

		}

		return null;
	}

	@Test
	public void testGetInstance() {
		String sql = "select id,name,birth from customers where id = ?";
		Customer cust = getInstance(Customer.class, sql, 12);
		System.out.println(cust);

		String sql1 = "select order_id orderId,order_name orderName from `order` where order_id = ?";
		Order order = getInstance(Order.class, sql1, 1);
		System.out.println(order);

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
