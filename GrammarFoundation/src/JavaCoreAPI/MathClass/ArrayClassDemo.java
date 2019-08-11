package JavaCoreAPI.MathClass;

import org.junit.Test;

import java.util.Arrays;

/*
@author 黄佳豪
@create 2019-07-23-15:26
*/
public class ArrayClassDemo {
    @Test
    public void test1() {
        int[] a = {1, 3, 5};
        int[] b = {1, 3, 5};
        int[] c = {5, 3, 1};//顺序不一样
        boolean equals = Arrays.equals(a, b);
        boolean equals1 = Arrays.equals(a, c);
        System.out.println(equals);//true
        System.out.println(equals1);//false
    }

    @Test
    public void test2() {
        int[] a = {2, 5, 5, 3, 1, 6};
        System.out.println(Arrays.toString(a));
    }
}
