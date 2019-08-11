package JavaWeb.JDBC.day2.java;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import JavaWeb.JDBC.day2.bean.Customer;
import JavaWeb.JDBC.day2.util.JDBCUtils;
import org.junit.Test;


/**
 * 针对于Customers表的通用查询操作
 * 
 * 通用：查询的字段个数、字段名不确定
 * 
 * @author Administrator
 *
 */
public class CustomersQueryTest {
	
	@Test
	public void testGetInstance() {
		String sql = "select id ,name,birth from customers where name = ?";
		Customer customer = getInstance(sql,"周杰伦");
		System.out.println(customer);
	}
	//Customers表的通用查询操作
	public Customer getInstance(String sql,Object ... args) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.获取连接
			conn = JDBCUtils.getConnection();
			// 2.预编译sql语句
			ps = conn.prepareStatement(sql);

			// 3.填充占位符
			for(int i = 0;i < args.length;i++) {
				ps.setObject(i + 1, args[i]);
			}

			// 4.调用executeQuery()，获取结果集
			rs = ps.executeQuery();
			
			//5.获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			//6.获取结果集中列的个数
			int columnCount = rsmd.getColumnCount();
			
			// 5.处理结果集
			if (rs.next()) {// ①判断指针的下一个位置是否有数据 ②如果返回true,指针下移。如果返回false,指针不下移。
				Customer cust = new Customer();
				
				for(int i = 0;i < columnCount ;i++) {
					
					Object columnValue = rs.getObject(i + 1);//获取列值
					
					String columnLabel = rsmd.getColumnLabel(i + 1);//获取结果集中列的名称
					//反射
					Class clazz = Customer.class;
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(cust, columnValue);
					
				}
				
				return cust;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			JDBCUtils.closeResource(conn, ps, rs);

		}

		return null;
	}

	// 查询操作
	/*
	 * ORM的思想(object relational mapping) 
	 * 一个数据表 与 一个java类对应 
	 * 表中的一个列 与 java类的一个属性对应
	 * 表中的一个行 与 java类的一个对象对应
	 * 
	 */
	@Test
	public void testQuery1() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.获取连接
			conn = JDBCUtils.getConnection();
			// 2.提供sql语句（包含占位符）
			String sql = "select id,name,email,birth from customers where id = ?";
			// 3.预编译sql语句
			ps = conn.prepareStatement(sql);

			// 4.填充占位符
			ps.setInt(1, 18);

			// 5.调用executeQuery()，获取结果集
			rs = ps.executeQuery();
			// 6.处理结果集
			if (rs.next()) {// ①判断指针的下一个位置是否有数据 ②如果返回true,指针下移。如果返回false,指针不下移。

				// int id = rs.getInt(1);
				// String name = rs.getString(2);
				// String email = rs.getString(3);
				// Date birth = rs.getDate(4);
				// 或者
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birth = rs.getDate("birth");

				// 方式一：
				// System.out.println("id : " + id + "name : " + name
				// + ",email : " + email + ",birth :" + birth);

				// 方式二：Object[] 不建议
				// 方式三：封装为对象
				Customer cust = new Customer(id, name, email, birth);
				System.out.println(cust);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7.关闭资源
			JDBCUtils.closeResource(conn, ps, rs);

		}

	}

}
