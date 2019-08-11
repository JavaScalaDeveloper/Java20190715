package JavaCoreAPI.Exception;

/*
@author 黄佳豪
@create 2019-07-22-15:10
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ZeroException {
    public static void main(String[] args) {
        int a = 10, b = 0;
        int c = 0;
        try {
            c = a / b;
        } catch (ArithmeticException e) {
//            e.printStackTrace();
            System.out.println("异常："+e.getMessage());
            b = 1;
            c = a / b;
        } finally {
            System.out.println(c);
        }
        IOExceptionDemo.test1();

    }

}

class IOExceptionDemo {
    public static void test1() {


        try {
            FileInputStream i = new FileInputStream("file.txt");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            System.out.println("执行过读取文件程序");
        }
    }
}