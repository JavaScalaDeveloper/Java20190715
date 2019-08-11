package Jdbc.Homework;

import Jdbc.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 演示通用的增删改查代码
 *
 * @author 黄佳豪
 * @create 2019-08-03-21:02
 */
public class UniversalTest {
    public static void main(String[] args) throws Exception {
        UniversalTest u = new UniversalTest();
        //演示删除
        String sql = "DELETE FROM customers WHERE id=?";
        int id = 20;
        u.delete(sql, id);
    }

    public <T> T getInstance(Class<T> clazz, String sql, Object... args) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        //直接使用get方法获取对应的类型的数据
        ResultSet rs = ps.executeQuery();
        //使用getMetaData()方法，得到表结构，包括列名，列的个数，列的数据类型。
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        if (rs.next()) {
            T t = clazz.newInstance();
            for (int i = 0; i < columnCount; i++) {
                Object columnVal = rs.getObject(i + 1);
                String columnLabel = rsmd.getColumnLabel(i + 1);
                Field field = clazz.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(t,columnVal);
            }
            return t;
        }
        JDBCUtils.closeResource(conn,ps,rs);
        return null;
    }

    /**
     * 删除数据
     *
     * @param sql
     * @param args
     * @throws Exception
     */
    public void delete(String sql, Object... args) throws Exception {
        //连接数据库
        Connection conn = JDBCUtils.getConnection();
        //创建PrepareStatement对象
        PreparedStatement pr = conn.prepareStatement(sql);
        //遍历参数
        for (int i = 0; i < args.length; i++) {
            pr.setObject(i + 1, args[i]);
        }
        int i = pr.executeUpdate();
        System.out.println("影响了" + i + "条数据。");
        JDBCUtils.closeResource(conn, pr);
    }
}
