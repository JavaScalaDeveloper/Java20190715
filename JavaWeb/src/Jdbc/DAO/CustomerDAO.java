package Jdbc.DAO;

import Jdbc.bean.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * @author 黄佳豪
 * @create 2019-08-04-10:29
 */
public class CustomerDAO extends DAODemo1 {
    /**
     * 查询表中所有记录
     * @param conn
     * @return
     */
    public List<Customer> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        List<Customer> list = getForList(conn, Customer.class, sql);
        return list;
    }
    /**
     * 查询指定id的对象
     * @param conn
     * @param id
     * @return
     */
    public Customer getById(Connection conn, int id) {
        String sql = "select id,name,email,birth from customers where id=?";
        Customer customer = getInstance(conn, Customer.class, sql, id);
        return customer;
    }
    /**
     * 删除数据表中的一条记录
     * @param conn
     * @param cust
     */
    public void updateCustomer(Connection conn, Customer cust) {
        String sql = "update customers set name=?,email=?,birth=? where id=?";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
    }
    /**
     * 删除指定id对应数据
     * @param conn
     * @param id
     */
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id=?";
        update(conn,sql,id);
    }
    /**
     * 向Customers表中插入一条数据
     */
    public void addCustomer(Connection conn, Customer cust) {
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        update(conn, sql,cust.getName(),cust.getEmail(),cust.getBirth());
    }
}
