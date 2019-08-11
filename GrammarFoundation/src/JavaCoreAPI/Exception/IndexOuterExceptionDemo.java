package JavaCoreAPI.Exception;

import org.junit.Test;

/*
@author 黄佳豪
@create 2019-07-22-16:36
*/
public class IndexOuterExceptionDemo {
    public static void main(String[] args) throws Exception {
        method4();
    }

    public static void method1() throws Exception {
        method2();
    }

    private static void method2() throws Exception {
        method3();
    }

    private static void method3() throws Exception {
        method4();
    }

    private static void method4() throws Exception {
        int[] arr = new int[3];
        arr[3] = 1;
        System.out.println(arr[3]);
    }
}
