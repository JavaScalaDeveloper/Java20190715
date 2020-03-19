package Jdbc;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*@author 黄佳豪
@create 2019-08-02-20:07*/


public class MySQLConnection {
/**
     * 获取数据库连接需要如下准备：
     * 1.加载MySQL驱动
     *
     * @throws SQLException*/


    @Test
    public void test1() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();//提供MySQL中实现接口Driver的类对象
        //提供url
        String url = "jdbc:mysql://localhost:3306/test";
        //提供用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "abc123");
        //获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }


/*     * 利用反射获取连接
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException*/


    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String className = "com.mysql.jdbc.Driver";
        Class clazz = Class.forName(className);
        Driver driver = (Driver) clazz.newInstance();
        //提供url
        String url = "jdbc:mysql://localhost:3306/test";
        //提供用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "abc123");
        //获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

/**
     * 方式三：使用DriverManager
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException*/


    @Test
    public void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //通过反射提供驱动,先获取四个基本信息
        String className = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "abc123";
        //创建驱动
        Class clazz = Class.forName(className);
        Driver driver = (Driver) clazz.newInstance();
        //注册驱动
        DriverManager.registerDriver(driver);
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

/**
     * 将DriverManager简化*/


    @Test
    public void test4() throws SQLException, ClassNotFoundException {
        //通过反射提供驱动,先获取四个基本信息
        String className = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "abc123";
        //创建驱动
        Class.forName(className);
/*Driver.class中找到了如下代码
        static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException var1) {
            throw new RuntimeException("Can't register driver!");
        }
        }*/


        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

/**
     *通过配置文件jdbc.properties连接 ★推荐
     * 便于维护
     */

    @Test
    public void test5() throws IOException, SQLException, ClassNotFoundException {
        //加载文件
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("src/Jdbc/jdbc.properties");
        pros.load(fis);
        //获取四个信息
        String driverClass = pros.getProperty("driverClass");
        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        //加载驱动
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
