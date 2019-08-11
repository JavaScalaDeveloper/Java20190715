package Jdbc.DBMatter;

import Jdbc.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 转账问题
 *
 * @author 黄佳豪
 * @create 2019-08-04-9:22
 */
public class TransActionDemo {
    @Test
    public void testUpdate() throws Exception {
        String sql1 = "update user_table set balance =balance-100 where user=?";
        String sql2 = "update user_table set balance =balance+100 where user=?";
        update(sql1, "AA");
//        System.out.println(1 / 0);//异常
        update(sql2, "BB");
        System.out.println("转账成功！");

    }

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

    /**
     * 更新2.0
     *
     * @param conn
     * @param sql
     * @param args
     * @throws Exception
     */
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

    //通用更新v1.0
    public static void update(String sql, Object... args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = JDBCUtils.getConnection();
        //插入sql
        ps = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        int i = ps.executeUpdate();
        System.out.println("影响了" + i + "条数据。");
        JDBCUtils.closeResource(conn, ps);
    }
}
