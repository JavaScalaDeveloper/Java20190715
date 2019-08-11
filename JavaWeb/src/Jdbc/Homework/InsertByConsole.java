package Jdbc.Homework;

import Jdbc.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * 练习1：从控制台向数据库的表customers中插入一条数据
 *
 * @author 黄佳豪
 * @create 2019-08-03-20:45
 */
public class InsertByConsole {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("id:");
        int id = input.nextInt();
        System.out.print("name:");
        String name = input.next();
        System.out.print("email:");
        String email = input.next();
        System.out.print("birth（xxxx年-xx月-xx日）:");
        Date birth = Date.valueOf(input.next());
        //插入数据
        String sql = "INSERT INTO customers(id,NAME,email,birth) VALUES(?,?,?,?)";
        update(sql, id, name, email, birth);
        System.out.println("插入成功！");
    }

    //更新操作
    public static void update(String sql, Object... args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = JDBCUtils.getConnection();
        //插入sql
        ps = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        ps.executeUpdate();
        JDBCUtils.closeResource(conn, ps);
    }
}
