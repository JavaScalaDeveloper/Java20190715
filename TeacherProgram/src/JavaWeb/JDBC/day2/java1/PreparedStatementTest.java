package JavaWeb.JDBC.day2.java1;

import java.sql.Connection;
import java.sql.PreparedStatement;

import JavaWeb.JDBC.day2.util.JDBCUtils;
import org.junit.Test;


/**
 * 使用PreparedStatement实现批量操作,这里主要指的是批量插入
 * 
 * 	insert / update / delete / select 
 * 
 *  方式一：使用Statement实现
 *  
 *  Statement st = conn.createStatement();
 *  for(int i = 1;i <= 20000;i++){
 *  	String sql = "insert into goods(name)values('name_' " + i +")";
 *  	st.execute(sql);
 *  }
 *  
 *
 */
public class PreparedStatementTest {
	
	/**
	 * 方式四：
	 * Connection 的 setAutoCommit(false)  /  commit()
	 */
	@Test
	public void testInsert3() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		
		//a. 不要自动提交数据
		conn.setAutoCommit(false);
		
		
		long start = System.currentTimeMillis();
		String sql = "insert into goods(name)values(?)";
		//预编译sql语句
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i = 1; i <= 1000000;i++) {
			ps.setObject(1, "name_" + i);
			//1.“攒”sql
			ps.addBatch();
			
			if( i % 500 == 0) {
				//2.执行
				ps.executeBatch();
				
				//3.清空
				ps.clearBatch();
			}
		}
		
		//b.提交数据
		conn.commit();
		
		long end = System.currentTimeMillis();
		System.out.println("花费的时间为：" + (end - start));//71526 - 387
		//1000000:16047 - 4945
		JDBCUtils.closeResource(conn, ps);
		
	}
	
	/**
	 * 方式三：
	 * ① 使用 addBatch() / executeBatch() / clearBatch()
	 * ② ?rewriteBatchedStatements=true&useServerPrepStmts=false
	 * ③ 使用更新的mysql 驱动：
	 * mysql-connector-java-5.1.37-bin.jar
	 * 
	 */
	@Test
	public void testInsert2() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		long start = System.currentTimeMillis();
		String sql = "insert into goods(name)values(?)";
		//预编译sql语句
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i = 1; i <= 1000000;i++) {
			ps.setObject(1, "name_" + i);
			//1.“攒”sql
			ps.addBatch();
			
			if( i % 500 == 0) {
				//2.执行
				ps.executeBatch();
				
				//3.清空
				ps.clearBatch();
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("花费的时间为：" + (end - start));//71526 - 387
		//1000000:16047
		
		JDBCUtils.closeResource(conn, ps);
		
	}
	
	
	/**
	 * 方式二：使用PreparedStatement 替换Statement
	 * @throws Exception 
	 */
	@Test
	public void testInsert1() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		long start = System.currentTimeMillis();
		String sql = "insert into goods(name)values(?)";
		//预编译sql语句
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i = 1; i <= 20000;i++) {
			ps.setObject(1, "name_" + i);
			ps.execute();
			
		}
		
		long end = System.currentTimeMillis();
		System.out.println("花费的时间为：" + (end - start));//71526
		
		JDBCUtils.closeResource(conn, ps);
	}
}
