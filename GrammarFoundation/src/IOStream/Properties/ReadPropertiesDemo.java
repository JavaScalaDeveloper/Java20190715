package IOStream.Properties;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/*
@author 黄佳豪
@create 2019-07-27-14:55
*/
public class ReadPropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties pro = new Properties();
        pro.load(new FileInputStream("GrammarFoundation\\src\\IOStream\\File\\db.properties"));
        //遍历集合
        pro.list(System.out);//打印所有键值对
        String username = pro.getProperty("username");
        System.out.println(username);
    }

    @Test
    public void test2() throws IOException {
        //测试写入文件
        Properties pro = new Properties();
        pro.setProperty("ls","000000");
        //将pro存储在配置文件
        pro.store(new FileOutputStream("D:\\Workspaces\\Java20190715\\GrammarFoundation\\src\\IOStream\\File\\db2.properties"),null);
    }
}
