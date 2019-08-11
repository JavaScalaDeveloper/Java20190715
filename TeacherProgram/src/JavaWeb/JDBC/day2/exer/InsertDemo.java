package JavaWeb.JDBC.day2.exer;

import JavaWeb.JDBC.day2.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @author 黄佳豪
 * @create 2019-08-03-19:19
 */
public class InsertDemo {
//练习1：从控制台向数据库的表customers中插入一条数据
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("id:");
        int id = s.nextInt();

        System.out.println("name:");
        String name = s.next();

        System.out.println("email:");
        String email = s.next();

        System.out.println("birth:");
        String birth = s.next();

        // 如果从控制台输入，编写一个sql语句
        String sql = "insert into customers(id,name,email,birth) values(?,?,?,?)";
        update(sql,id,name,email,birth);
        System.out.println("插入成功！");

    }

    // 通用的增删改操作
    public static void update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, null);
        }

    }
}
