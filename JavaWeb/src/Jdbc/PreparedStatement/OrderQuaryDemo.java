package Jdbc.PreparedStatement;

import Jdbc.JDBCUtils;
import Jdbc.bean.Order;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 对order表操作
 *
 * @author 黄佳豪
 * @create 2019-08-03-16:25
 */
public class OrderQuaryDemo {
    @Test
    public void test1() throws Exception {
        Connection coo = JDBCUtils.getConnection();
//        String sql = "select id,name,email,birth from customers where id=?";
        String sql = "select order_id,order_name,order_date from `order` where order_id=?";
        //预编译sql
        PreparedStatement ps = coo.prepareStatement(sql);
        ps.setInt(1,1);
        //调用executeQuary（），获取结果集
        ResultSet i = ps.executeQuery();
        //处理结果集
        if (i.next()) {//判断指针下一个位置是否有数据，如果返回true则指针下移
            /*int id = i.getInt(1);
            String name = i.getString(2);
            String email = i.getString(3);
            Date birth = i.getDate(4);*/
            int orderId = i.getInt(1);
            String orderName=i.getString(2);
            Date orderDate=i.getDate(3);
            //方式一：sout
//            System.out.println("id:"+id+" name:"+name+" email:"+email+" birthDay:"+birth);
            //方式二：封装为对象
//            Customer cust = new Customer(id,name,email,birth);
            Order order = new Order(orderId, orderName, orderDate);
            System.out.println(order);
        }
        JDBCUtils.closeResource(coo,ps,i);
    }
}
