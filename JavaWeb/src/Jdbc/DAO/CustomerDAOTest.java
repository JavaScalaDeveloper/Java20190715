/*
package Jdbc.DAO;

import Jdbc.JDBCUtils;
import Jdbc.bean.Customer;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import java.sql.Connection;
import java.sql.Date;
import java.mockutils.List;

*/
/**
 * @author 黄佳豪
 * @create 2019-08-04-10:54
 *//*

public class CustomerDAOTest {
    @Test
    public void testGetAll() throws Exception {
        CustomerDAO dao = new CustomerDAO();
//        Connection conn = JDBCUtils.getConnection();
//        Connection conn = JDBCUtils.getC3P0Connection();
        Connection conn = JDBCUtils.getDBCPConnection();
        List<Customer> all = dao.getAll(conn);
        all.forEach(System.out::println);
        JDBCUtils.closeResource(conn,null);
    }
    */
/**
     * 增
     *
     * @throws Exception
     *//*

    @Test
    public void testGetOne() throws Exception {
        CustomerDAO dao = new CustomerDAO();
        Connection conn = JDBCUtils.getConnection();
        Customer cust = dao.getById(conn, 8);
        System.out.println(cust);//Customer{id=8, name='陈道明', email='bdf@126.com', birth=2014-01-17}
        JDBCUtils.closeResource(conn,null);
    }
    @Test
    public void testAdd() throws Exception {
        CustomerDAO dao = new CustomerDAO();
        Connection conn = JDBCUtils.getConnection();
        Customer cust = new Customer(1, "王五", "1235@qq.com", new Date(21315434654L));
        dao.addCustomer(conn, cust);
    }
}
*/
