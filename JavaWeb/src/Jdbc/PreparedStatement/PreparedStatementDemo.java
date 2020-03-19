/*
package Jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Jdbc.JDBCUtils;
import org.junit.Test;


*/
/**
 * 使用PreparedStatement实现数据表中数据的增删改操作。
 *
 * 1.PreparedStatement 是 java.sql下定义的一个接口，是Statement的子接口
 *
 * @author Administrator
 *
 *//*

@SuppressWarnings("all")
public class PreparedStatementDemo {

    //测试
    @Test
    public void testCommonUpdate() {
		String sql = "delete from customers where id = ?";
		update(sql,36);


     */
/*   String sql = "update `order` set order_name = ? where order_id = ?";//order为关键字，需要添加``
        update(sql,"MM","4");*//*

    }

    // 使用PreparedStatement实现通用的增、删、改操作。
    // 通用：① 增、删、改操作都可以使用 ② 针对于数据库下的不同的表都可以用
    public void update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.获取数据库连接
            conn = JDBCUtils.getConnection();
            // 2.
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for(int i = 0;i < args.length;i++) {
                ps.setObject(i + 1, args[i]);
            }

            // 4.执行
            int count = ps.executeUpdate();

            System.out.println("影响了" + count + "条数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6.
            JDBCUtils.closeResource(conn, ps,null);
        }

    }

    // 使用PreparedStatement实现数据的修改
    @Test
    public void testUpdate() {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.
            conn = JDBCUtils.getConnection();
            // 2.
            String sql = "update customers set email = ? where id >= ?";
            // 3.
            ps = conn.prepareStatement(sql);
            // 4.
            ps.setString(1, "yinfei@126.com");
            ps.setInt(2, 19);
            // 5.
            int count = ps.executeUpdate();

            System.out.println("修改了" + count + "条数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6.
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (ps != null) {//在空指针异常时关闭
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 使用PreparedStatement实现数据的添加
    @Test
    public void testInsert() {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 获取数据库的连接
            conn = JDBCUtils.getConnection();
            // 2.提供一个包含占位符的sql语句
            // ?：占位符
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            // 3. 调用Connection的方法，获取一个PreparedStatement：预编译sql语句
            ps = conn.prepareStatement(sql);
            // 4.填充占位符
            ps.setString(1, "银飞");
            ps.setString(2, "jinfei@126.com");
            ps.setDate(3, new Date(235432532532L));// 数据库中的Date 对应java中的java.sql.Date
            // 5.执行
            // ps.execute();
            // 返回修改的条数
            int count = ps.executeUpdate();
            System.out.println("添加了" + count + "条记录");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6.资源的关闭
            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    // 测试连接
    @Test
    public void testConnection() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }

}
*/
