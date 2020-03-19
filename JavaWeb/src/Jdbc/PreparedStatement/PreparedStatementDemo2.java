/*
package Jdbc.PreparedStatement;

import Jdbc.JDBCUtils;
import Jdbc.bean.Customer;
import Jdbc.bean.Order;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.mockutils.ArrayList;
import java.mockutils.List;

*/
/**
 * 针对于不同的表，使用PreparedStatement通用操作
 *
 * @author 黄佳豪
 * @create 2019-08-03-17:05
 *//*

public class PreparedStatementDemo2 {
    @Test
    public void testGetForList() throws Exception {
        String sql = "select id,name from customers where id=?";
        List<Customer> list = getForList(Customer.class, sql, 12);
        list.forEach(System.out::println);
    }

    */
/**
     * 通用的查询，返回多条记录
     *
     * @throws Exception
     *//*

    public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) throws Exception {
        Connection coo = JDBCUtils.getConnection();
        List<T> list = new ArrayList<>();
        //预编译sql
        PreparedStatement ps = coo.prepareStatement(sql);
        ps.setInt(1, 1);
        //调用executeQuary（），获取结果集
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        //处理结果集
        while (rs.next()) {//判断指针下一个位置是否有数据，如果返回true则指针下移
            T t = clazz.newInstance();
            for (int i = 0; i < columnCount; i++) {
                Object columnValue = rs.getObject(i + 1);
                String columnLabel = rsmd.getColumnLabel(i + 1);
                Field field = clazz.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(t, columnValue);
            }
            list.add(t);
        }
        JDBCUtils.closeResource(coo, ps, rs);
        return list;
    }

    @Test
    public void testGetInstance() throws Exception {
        String sql = "select id,name from customers where id=?";
        Customer cust = getInstance(Customer.class, sql, 12);
        System.out.println(cust);
        String sql1 = "select order_id orderId,order_name orderName from `order` where order_id=?";//一定要起别名
        Order order = getInstance(Order.class, sql1, 1);
        System.out.println(order);
    }

    */
/**
     * 通用的查询，返回一条记录
     *
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     * @throws Exception
     *//*

    public <T> T getInstance(Class<T> clazz, String sql, Object... args) throws Exception {
        Connection coo = JDBCUtils.getConnection();
        //预编译sql
        PreparedStatement ps = coo.prepareStatement(sql);
        ps.setInt(1, 1);
        //调用executeQuary（），获取结果集
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        //处理结果集
        if (rs.next()) {//判断指针下一个位置是否有数据，如果返回true则指针下移
            T t = clazz.newInstance();
            for (int i = 0; i < columnCount; i++) {
                Object columnValue = rs.getObject(i + 1);
                String columnLabel = rsmd.getColumnLabel(i + 1);
                Field field = clazz.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(t, columnValue);
            }
            return t;
        }
        JDBCUtils.closeResource(coo, ps, rs);
        return null;
    }
}
*/
