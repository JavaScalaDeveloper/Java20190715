package Jdbc.PreparedStatement;

import Jdbc.JDBCUtils;
import Jdbc.bean.Customer;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**针对Customers表操作
 * @author 黄佳豪
 * @create 2019-08-03-16:04
 */
public class CustomersQueryDemo {
    @Test
    public void testGetInstance() throws Exception {
        String sql = "select id,name from customers where id=?";
        Customer customer = getInstance(sql, 10);
        System.out.println(customer);
    }
    public Customer getInstance(String sql,Object ... args) throws Exception {
        Connection coo = JDBCUtils.getConnection();
//        String sql = "select id,name,email,birth from customers where id=?";
        //预编译sql
        PreparedStatement ps = coo.prepareStatement(sql);
//        ps.setInt(1,18);
        //调用executeQuary（），获取结果集
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1,args[i]);
        }
        ResultSet rs = ps.executeQuery();
        //获取结果集的元数据
        ResultSetMetaData rsmd=rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        //处理结果集
        if (rs.next()) {//判断指针下一个位置是否有数据，如果返回true则指针下移
            Customer cust=new Customer();
            for (int i = 0; i < columnCount; i++) {
                Object columnValue= rs.getObject(i+1);
                String columnLabel = rsmd.getColumnLabel(i + 1);//获取结果集中的名称
                //反射
                Class<Customer> clazz = Customer.class;
                Field field = clazz.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(cust,columnValue);
            }
            //方式二：封装为对象
//            Customer cust = new Customer(id,name,email,birth);
            System.out.println(cust);
            return cust;
        }
        JDBCUtils.closeResource(coo,ps,rs);
        return null;
    }
    @Test
    public void testQuary() throws Exception {
        Connection coo = JDBCUtils.getConnection();
        String sql = "select id,name,email,birth from customers where id=?";
        //预编译sql
        PreparedStatement ps = coo.prepareStatement(sql);
        ps.setInt(1,18);
        //调用executeQuary（），获取结果集
        ResultSet i = ps.executeQuery();
        //处理结果集
        if (i.next()) {//判断指针下一个位置是否有数据，如果返回true则指针下移
            int id = i.getInt(1);
            String name = i.getString(2);
            String email = i.getString(3);
            Date birth = i.getDate(4);
            //方式一：sout
//            System.out.println("id:"+id+" name:"+name+" email:"+email+" birthDay:"+birth);
            //方式二：封装为对象
            Customer cust = new Customer(id,name,email,birth);
            System.out.println(cust);
        }
        JDBCUtils.closeResource(coo,ps,i);
    }
}
