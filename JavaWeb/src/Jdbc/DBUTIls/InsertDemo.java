package Jdbc.DBUTIls;

import Jdbc.JDBCUtils;
import Jdbc.bean.Customer;
import jdk.nashorn.internal.scripts.JD;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 黄佳豪
 * @create 2019-08-04-17:22
 */
public class InsertDemo {
    /**
     * 查询一些特殊数据：最大值、平均数
     */
    @Test
    public void testScalarValue() throws Exception {
        QueryRunner qr = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();
        /*String sql = "select max(birth) from customers";
        ScalarHandler handler=new ScalarHandler();
        Date birth= (Date) qr.query(conn, sql, handler);//id==6
        System.out.println(birth);*/
        ScalarHandler handler = new ScalarHandler();
        String sql = "select count(*) from customers";
        long count = (long) qr.query(conn, sql, handler);
        System.out.println(count);
//        JDBCUtils.closeResource(conn, null);
        DbUtils.close(conn);
    }

    /**
     * 查询表中的一条记录，以key-value的方式显示
     *
     * @throws Exception
     */
    @Test
    public void testQueryForMap() throws Exception {
        QueryRunner qr = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select id,name,email,birth from customers where id=?";
        MapHandler handler = new MapHandler();
        Map<String, Object> map = qr.query(conn, sql, handler, 6);//id==6
        System.out.println(map);
        JDBCUtils.closeResource(conn, null);
    }

    /**
     * 查询多条记录构成的集合
     *
     * @throws Exception
     */
    @Test
    public void testQueryForList() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select id,name,email,birth from customers where id<?";
        BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
        List<Customer> list = runner.query(conn, sql, handler, 10);
        list.forEach(System.out::println);
        JDBCUtils.closeResource(conn, null);
    }

    /**
     * 查询表中一条记录
     */
    @Test
    public void testQuary() throws Exception {
        QueryRunner qr = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select id,name,email,birth from customers where id=?";
        BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
        Customer customer = qr.query(conn, sql, handler, 6);//id==6
        System.out.println(customer);
        JDBCUtils.closeResource(conn, null);
    }

    /**
     * 向表中插入数据
     *
     * @throws Exception
     */
    @Test
    public void testInsert() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getDBCPConnection();
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        runner.update(conn, sql, "杨瑞", "yang@email.com", "2019-08-04");
        JDBCUtils.closeResource(conn, null);
    }
}
