/*
package Jdbc.Homework;

import Jdbc.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

*/
/**
 * @author 黄佳豪
 * @create 2019-08-04-20:37
 *//*

public class TransactionTest {
    */
/**
     * 转账事务操作
     *
     *//*

    @Test
    public void testUpdateWithTx() {
        Connection conn=null;
        try {
            String sql1 = "update user_table set balance=balance-100 where user=?";
            String sql2 = "update user_table set balance=balance+100 where user=?";
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            updateWithTx(conn,sql1,"AA");
            System.out.println(1/0);
            updateWithTx(conn,sql2,"BB");
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }finally {
            if (conn != null) {
                JDBCUtils.closeResource(conn,null);
            }
        }
    }
    */
/**
     * 通用的增删改，影响事务
     *//*

    public void updateWithTx(Connection conn, String sql, Object... args) {
        PreparedStatement ps=null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            int i = ps.executeUpdate();
            System.out.println("影响了"+i+"条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
/**
     * 出错的转账方式
     * @throws Exception
     *//*

    @Test
    public void testUpdate() throws Exception {
        String sql1 = "update user_table set balance=balance-100 where user=?";
        String sql2 = "update user_table set balance=balance+100 where user=?";
        update(sql1,"AA");
        System.out.println(1/0);//演示异常
        update(sql2,"BB");
        System.out.println("转账成功");
    }
    //通用的增删改
    public void update(String sql, Object... args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            int i = ps.executeUpdate();
            System.out.println("影响了" + i + "条数据");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,ps,null);
        }
    }
}
*/
