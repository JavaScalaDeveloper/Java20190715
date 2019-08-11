package Jdbc;

import Jdbc.DBConnectionPool.DBCPTest;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*
@author 黄佳豪
@create 2019-08-02-21:07
*/
@SuppressWarnings("all")
public class JDBCUtils {
    /*public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        connection();
    }*/
    public static Connection connection() throws IOException, SQLException, ClassNotFoundException {
        //加载文件
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Workspaces\\Java20190715\\JavaWeb\\src\\jdbc.properties");
        pros.load(fis);
        //获取四个信息
        String driverClass = pros.getProperty("driverClass");
        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        //加载驱动
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, password);
//        System.out.println(conn);
        return conn;
    }

    // 关闭资源的操作
    public static void closeResource(Connection conn, Statement st, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 关闭资源的操作
    public static void closeResource(Connection conn, Statement st) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 获取连接的操作
    public static Connection getConnection() throws Exception {
        // 1.加载配置文件
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Workspaces\\Java20190715\\JavaWeb\\src\\jdbc.properties");
        pros.load(fis);

        // 2.获取连接所需的四个基本信息
        String driverClass = pros.getProperty("driverClass");
        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        // 3.加载驱动
        Class.forName(driverClass);

        // 4.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

        return conn;
    }

    //使用c3p0连接
    public static Connection getC3P0Connection() throws PropertyVetoException, SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        cpds.setUser("root");
        cpds.setPassword("abc123");
        cpds.setMaxPoolSize(100);
        Connection conn = cpds.getConnection();
        return conn;
//        System.out.println(conn);
    }

    //使用dbcp连接数据库
    private static DataSource source;

    static {//保证此连接池（数据源）是唯一的
        Properties pros = new Properties();
        //方式一
//        FileInputStream is = new FileInputStream("src/dbcp.properties");
        //方式二:使用类的加载器
        InputStream is = DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
        try {
            pros.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getDBCPConnection() throws Exception {
        Connection conn = source.getConnection();
        return conn;
    }
}
