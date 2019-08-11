package IOStream.PrintStream;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/*
@author 黄佳豪
@create 2019-07-27-10:59
in标准输入流     inputStream     键盘
out 标准输出流   PrintStream     显示器
err 标准错误流
*/
public class SystemIODemo {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;//标准输入流
        int read = is.read();
        System.out.println((char)read);
    }

    @Test
    public void test1() throws IOException {
        InputStream is = System.in;
        int read = is.read();
        System.out.println((char)read);
    }
}
