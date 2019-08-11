package JavaWeb.JDBC.day3.java1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import JavaWeb.JDBC.day3.bean.Customer;
import JavaWeb.JDBC.day3.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;


public class QueryRunnerTest {
	
	//查询一些特殊数据：查询最大值 、 平均数
	@Test
	public void testScalarValue() throws Exception {
		QueryRunner runner = new QueryRunner();
		
		Connection conn = JDBCUtils.getConnection();
		ScalarHandler handler = new ScalarHandler();
		
		//需求一：查询birth的最大值
//		String sql = "select max(birth) from customers";
//		Date birth = (Date) runner.query(conn, sql, handler);
//		System.out.println(birth);
		//需求二：查询表中的数据的数量
		String sql = "select count(*) from customers";
		long count = (long) runner.query(conn, sql, handler);
		System.out.println(count);
		
		JDBCUtils.closeResource(conn, null);
	}
	
	//查询表中的一条记录，以key-value的方式显示
	@Test
	public void testQueryForMap() throws Exception {
		QueryRunner runner = new QueryRunner();
		
		Connection conn = JDBCUtils.getConnection();
		
		String sql = "select id,name,email,birth from customers where id = ?";
		
		MapHandler handler = new MapHandler();
		
		Map<String, Object> map = runner.query(conn, sql, handler, 6);
		
		System.out.println(map);
		
		JDBCUtils.closeResource(conn, null);
	}
	
	//查询表中的多条记录构成的集合：BeanListHandler
	@Test
	public void testQueryForList() throws Exception {
		QueryRunner runner = new QueryRunner();
		
		Connection conn = JDBCUtils.getConnection();
		
		String sql = "select id,name,email,birth from customers where id < ?";
		
		BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
		
		List<Customer> list = runner.query(conn, sql, handler, 10);
		
		list.forEach(System.out::println);
		
		JDBCUtils.closeResource(conn, null);
	}
	
	//查询表中的一条记录:BeanHandler
	@Test
	public void testQueryInstance() throws Exception {
		
		QueryRunner runner = new QueryRunner();
		
		Connection conn = JDBCUtils.getConnection();
		
		String sql = "select id,name,email,birth from customers where id = ?";
		
		BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
		
		Customer customer = runner.query(conn, sql, handler, 6);
		
		System.out.println(customer);
		
		JDBCUtils.closeResource(conn, null);
		
		
	}
	
	@Test
	public void testInsert() {
		
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			
			conn = JDBCUtils.getC3P0Connection();
			String sql = "insert into customers(name,email,birth)values(?,?,?)";
			//调用如下的update()方法实现增、删、改的操作
			runner.update(conn, sql,"张三","zhangsan@gmail.com","2019-08-04");
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCUtils.closeResource(conn, null);
	}
	
}
