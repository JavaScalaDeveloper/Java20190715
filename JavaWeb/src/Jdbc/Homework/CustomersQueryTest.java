package Jdbc.Homework;

import Jdbc.JDBCUtils;
import Jdbc.bean.Customer;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * 针对Customers表的通用查询操作
 *
 * @author 黄佳豪
 * @create 2019-08-03-21:44
 */
public class CustomersQueryTest {
    @Test
    public void testGetInstance() throws Exception {
        String sql = "select id,name,email,birth from customers where name=?";
        Customer customer = getInstance(sql, "周杰伦");
        System.out.println(customer);
    }
    //Customer表的通用查询操作
    public Customer getInstance(String sql, Object... args) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        //遍历填充占位符
        for (int i = 0; i <args.length; i++) {
            ps.setObject(i+1,args[i]);
        }
        //获取结果集
        ResultSet rs = ps.executeQuery();
        //获取结果集的元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        //获取结果集中的个数
        int columnCount = rsmd.getColumnCount();
        if (rs.next()) {
            Customer cust = new Customer();
            for (int i = 0; i < columnCount; i++) {
                //获取列值
                Object columnValue = rs.getObject(i + 1);
                //获取列名
                String columnLabel = rsmd.getColumnLabel(i + 1);
                //反射
                Class<Customer> clazz = Customer.class;
                Field field = clazz.getDeclaredField(columnLabel);//获取对象属性fifi
                field.setAccessible(true);
                field.set(cust,columnValue);
            }
            return cust;
        }
        JDBCUtils.closeResource(conn,ps,rs);
        return null;
    }

    /**
     * ORM对象关联映射思想
     * 一个数据表 与 一个java类对应
     * 表中的一个列 与 java类的一个属性对应
     * 表中的一个行 与 java类的一个对象对应
     */
    @Test
    public void testQueryByORM() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        //根据id查询其他信息
        String sql = "select id,name,email,birth from customers where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        //填充sql中的占位符
        ps.setObject(1, 18);
        //调用executeQuery方法获取结果集
        ResultSet rs = ps.executeQuery();
        //遍历结果集
        if (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            Date birth = Date.valueOf(rs.getString("birth"));
        //封装为对象
            Customer cust = new Customer(id, name, email, birth);
            System.out.println(cust);
        }
    }
}
