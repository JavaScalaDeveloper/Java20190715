package JavaWeb.JDBC.day2.java;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import JavaWeb.JDBC.day2.bean.Order;
import JavaWeb.JDBC.day2.util.JDBCUtils;
import org.junit.Test;



/**
 * 针对于order表的查询操作
 * 
 * @author Administrator
 *
 */
public class OrderQueryTest {
	
	/**
	 * 如果表的字段名和类的属性名不一致，要求：
	 * 查询的语句中，使用类的属性名作为字段的别名出现。
	 */
	@Test
	public void testGetInstance() {
		
		String sql = "select order_id orderId,order_name orderName from `order` where order_id = ?";
		Order order = getInstance(sql, 1);
		System.out.println(order);
		
	}

	// order表的通用查询操作
	public Order getInstance(String sql, Object... args) {

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

			// 5.处理结果集
			if (rs.next()) {// ①判断指针的下一个位置是否有数据 ②如果返回true,指针下移。如果返回false,指针不下移。
				Order order = new Order();

				for (int i = 0; i < columnCount; i++) {

					Object columnValue = rs.getObject(i + 1);// 获取列值

					String columnLabel = rsmd.getColumnLabel(i + 1);// 获取结果集中列的别名 
					
					System.out.println(columnLabel);
					// 反射
					Class clazz = Order.class;
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(order, columnValue);

				}

				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			JDBCUtils.closeResource(conn, ps, rs);

		}

		return null;
	}

	@Test
	public void testQuery1() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.获取连接
			conn = JDBCUtils.getConnection();
			// 2.提供sql语句（包含占位符）
			// String sql = "select id,name,email,birth from customers where id = ?";
			String sql = "select order_id,order_name,order_date from `order` where order_id = ?";
			// 3.预编译sql语句
			ps = conn.prepareStatement(sql);

			// 4.填充占位符
			ps.setInt(1, 1);

			// 5.调用executeQuery()，获取结果集
			rs = ps.executeQuery();
			// 6.处理结果集
			if (rs.next()) {// ①判断指针的下一个位置是否有数据 ②如果返回true,指针下移。如果返回false,指针不下移。

				// int id = rs.getInt(1);
				// String name = rs.getString(2);
				// String email = rs.getString(3);
				// Date birth = rs.getDate(4);
				// 封装为对象
				// Customer cust = new Customer(id, name, email, birth);
				// System.out.println(cust);

				int orderId = rs.getInt(1);
				String orderName = rs.getString(2);
				Date orderDate = rs.getDate(3);

				Order order = new Order(orderId, orderName, orderDate);
				System.out.println(order);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			JDBCUtils.closeResource(conn, ps, rs);

		}

	}

}
