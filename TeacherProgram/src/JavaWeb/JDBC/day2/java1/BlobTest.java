package JavaWeb.JDBC.day2.java1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import JavaWeb.JDBC.day2.bean.Customer;
import JavaWeb.JDBC.day2.util.JDBCUtils;
import org.junit.Test;


public class BlobTest {
	
	//2.从数据表中读取Blob类型的数据
	//使用try-catch-finally处理异常
	@Test
	public void testQueryBlob() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		
		String sql = "select id,name,email,birth,photo from customers where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, 21);
		
		ResultSet rs = ps.executeQuery();
		InputStream is = null;
		FileOutputStream fos = null;
		if(rs.next()) {
			//
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date birth = rs.getDate("birth");
			
			Customer cust = new Customer(id, name, email, birth);
			System.out.println(cust);
			
			//读取Blob类型
			Blob blob = rs.getBlob("photo");
			is = blob.getBinaryStream();
			fos = new FileOutputStream("abc.png");
			byte[] buffer = new byte[1024];
			int len;
			while((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			
		}
		
		JDBCUtils.closeResource(conn, ps, rs);
		
		if(is != null) {
			is.close();
		}
		if(fos != null) {
			fos.close();
		}
	}
	
	
	//1.向数据表中插入Blob类型的变量
	//使用try-catch-finally处理异常
	@Test
	public void testInsertBlob() throws Exception {
		
		Connection conn = JDBCUtils.getConnection();
		
		String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		//
		ps.setObject(1, "张益达");
		ps.setObject(2, "dada@126.com");
		ps.setObject(3, "1998-09-08");
		FileInputStream fis = new FileInputStream("D:\\Workspaces\\Java20190715\\TeacherProgram\\src\\JavaWeb\\JDBC\\day2\\java1\\beauty.png");
		ps.setBlob(4, fis);
		
		//
		ps.executeUpdate();
		
		JDBCUtils.closeResource(conn, ps);
		if(fis != null) {
			fis.close();
		}
		
		
		
	}
}
