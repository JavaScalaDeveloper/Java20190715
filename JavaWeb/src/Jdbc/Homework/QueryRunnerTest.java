package Jdbc.Homework;

import Jdbc.JDBCUtils;
import Jdbc.bean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 黄佳豪
 * @create 2019-08-04-21:13
 */
public class QueryRunnerTest {

    //查询表中的一条记录
    @Test
    public void testQueryInstance() throws Exception {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select id,name,email,birth from customers where id=?";
        BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
        Customer query = runner.query(conn, sql, handler, 10);
        System.out.println(query);
        JDBCUtils.closeResource(conn,null);
    }
    /**
     * 简单的插入
     */
    @Test
    public void testInsert() throws Exception {
        Connection conn=null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getDBCPConnection();
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            runner.update(conn, sql, "王八", "wangba@email.com", "2019-08-04");

        } catch (SQLException e) {
            e.getMessage();
        }
        JDBCUtils.closeResource(conn,null);
    }
}
