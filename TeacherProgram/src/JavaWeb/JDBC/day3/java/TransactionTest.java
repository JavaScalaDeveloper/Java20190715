package JavaWeb.JDBC.day3.java;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import JavaWeb.JDBC.day3.util.JDBCUtils;
import org.junit.Test;


/**
 * 1.事务：一组逻辑操作单元,使数据从一种状态变换到另一种状态。
 *
 * 2.事务处理的原则：
 * 保证所有事务都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式。
 * 当在一个事务中执行多个操作时，要么所有的事务都被提交(commit)，那么这些修改就永久地保存下来；
 * 要么数据库管理系统将放弃所作的所有修改，整个事务回滚(rollback)到最初状态。

 *
 * @author Administrator
 *
 */
public class TransactionTest {

    // 通用的查询，返回一条记录 （version 2.0）
    public <T> T getInstance(Connection conn,Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.预编译sql语句
            ps = conn.prepareStatement(sql);

            // 2.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            // 3.调用executeQuery()，获取结果集
            rs = ps.executeQuery();

            // 4.获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            // 5.获取结果集中列的个数
            int columnCount = rsmd.getColumnCount();

            // 6.处理结果集
            if (rs.next()) {// ①判断指针的下一个位置是否有数据 ②如果返回true,指针下移。如果返回false,指针不下移。

                T t = clazz.newInstance();

                for (int i = 0; i < columnCount; i++) {// 处理列

                    Object columnValue = rs.getObject(i + 1);// 获取列值

                    String columnLabel = rsmd.getColumnLabel(i + 1);// 获取结果集中列的别名

                    // 反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);

                }

                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7.关闭资源
            JDBCUtils.closeResource(null, ps, rs);

        }

        return null;
    }


    /*
     * 演示转账操作
     *
     */
    @Test
    public void testUpdateWithTx() {

        Connection conn = null;
        try {
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            String sql2 = "update user_table set balance = balance + 100 where user = ?";

            conn = JDBCUtils.getConnection();

            //1.设置不能自动提交数据
            conn.setAutoCommit(false);
            //过程一：
            updateWithTx(conn,sql1,"AA");

            //出现异常
            System.out.println(10 / 0);

            //过程二：
            updateWithTx(conn,sql2,"BB");

            //2.提交数据
            conn.commit();

            System.out.println("转账成功！");
        } catch (Exception e) {
            e.printStackTrace();

            try {
                //3.回滚数据
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }finally {
            if(conn != null) {
                //关闭连接
                JDBCUtils.closeResource(conn, null);

            }
        }


    }


    //通用的增删改 （version 2.0）
    public void updateWithTx(Connection conn ,String sql, Object... args) {
        PreparedStatement ps = null;
        try {
            // 1.
            ps = conn.prepareStatement(sql);
            // 2.填充占位符
            for(int i = 0;i < args.length;i++) {
                ps.setObject(i + 1, args[i]);
            }

            // 3.执行
            int count = ps.executeUpdate();

            System.out.println("影响了" + count + "条数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.连接一定不要关闭！
            JDBCUtils.closeResource(null, ps,null);
        }
    }

    /*
     * 1. 数据一旦提交，不可回滚。
     * 2. 哪些操作，会导致数据的提交：
     * 情况一：执行的DML操作，默认情况下，一旦执行完，就会自动提交数据。 （set autocommit = false）
     * 情况二：一旦断开数据库的连接，也会提交之前未提交的数据。
     *
     */

    /*
     * 例子：
     * AA 向 BB 转账 100
     *
     * 过程一：
     * update user_table set balance = balance - 100 where user = AA.
     * 过程二：
     * update user_table set balance = balance + 100 where user = BB.
     *
     *
     */
    @Test
    public void testUpdate() {

        String sql1 = "update user_table set balance = balance - 100 where user = ?";
        String sql2 = "update user_table set balance = balance + 100 where user = ?";


        update(sql1,"AA");

        //模拟网络出现阻塞的异常
        System.out.println(10 / 0);


        update(sql2,"BB");

        System.out.println("转账成功");

    }


    //通用的增删改 （version 1.0）
    public void update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.
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
            // 5.
//            JDBCUtils.closeResource(conn, ps,null);
        }

    }

}
