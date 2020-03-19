/*
package Jdbc.DBUTIls;

import Jdbc.JDBCUtils;
import Jdbc.bean.Customer;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.mockutils.List;
import java.mockutils.Map;
import java.sql.Connection;
import java.sql.Date;

*
 * @author &#x9ec4;&#x4f73;&#x8c6a;
 * @create 2019-08-04-17:22



public class InsertDemo {
*
     * &#x67e5;&#x8be2;&#x4e00;&#x4e9b;&#x7279;&#x6b8a;&#x6570;&#x636e;&#xff1a;&#x6700;&#x5927;&#x503c;&#x3001;&#x5e73;&#x5747;&#x6570;



    @Test
    public void testScalarValue() throws Exception {
        QueryRunner qr = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();
String sql = "select max(birth) from customers";
        ScalarHandler handler=new ScalarHandler();
        Date birth= (Date) qr.query(conn, sql, handler);//id==6
        System.out.println(birth);

        ScalarHandler handler = new ScalarHandler();
        String sql = "select count(*) from customers";
        long count = (long) qr.query(conn, sql, handler);
        System.out.println(count);
//        JDBCUtils.closeResource(conn, null);
        DbUtils.close(conn);
    }


  * &#x67e5;&#x8be2;&#x8868;&#x4e2d;&#x7684;&#x4e00;&#x6761;&#x8bb0;&#x5f55;&#xff0c;&#x4ee5;key-value&#x7684;&#x65b9;&#x5f0f;&#x663e;&#x793a;
     *
     * @throws Exception



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


     * &#x67e5;&#x8be2;&#x591a;&#x6761;&#x8bb0;&#x5f55;&#x6784;&#x6210;&#x7684;&#x96c6;&#x5408;
     *
     * @throws Exception


   // @Test
    public void testQueryForList() throws Exception {
//        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select id,name,email,birth from customers where id<?";
        BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
        List<Customer> list = runner.query(conn, sql, handler, 10);
        list.forEach(System.out::println);
        JDBCUtils.closeResource(conn, null);
    }


     * &#x67e5;&#x8be2;&#x8868;&#x4e2d;&#x4e00;&#x6761;&#x8bb0;&#x5f55;


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

*
     * &#x5411;&#x8868;&#x4e2d;&#x63d2;&#x5165;&#x6570;&#x636e;
     *
     * @throws Exception


    @Test
    public void testInsert() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getDBCPConnection();
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        runner.update(conn, sql, "&#x6768;&#x745e;", "yang@email.com", "2019-08-04");
        JDBCUtils.closeResource(conn, null);
    }
}
*/
