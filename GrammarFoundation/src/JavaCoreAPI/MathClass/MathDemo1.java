package JavaCoreAPI.MathClass;

import com.sun.javafx.tk.DummyToolkit;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/*
@author 黄佳豪
@create 2019-07-23-11:34
*/
public class MathDemo1 {
    public static void main(String[] args) {
        System.out.println(Math.E);
        System.out.println(Math.pow(2,6));
        System.out.println(Math.ceil(-1.000000001));//向上取整
        System.out.println(Math.floor(-1.000000001));//向下取整
        System.out.println(Math.max(24,354));
        //Arrays
        int[] a = {1,54,7, 3, 5, 6, 7, 8};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {

            System.out.print(a[i]+"\t");
        }
    }

    @Test
    public void test() {
        String[] a = {"john", "lucy", "jack"};
        Arrays.sort(a, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                String s1=(String)o1;
                String s2=(String)o2;
                return  s1.compareTo(s2);

            }
        });
        printArr(a);
    }

    @Test
    public void test2() {
        int[] a = {32, 4, 52, 34, 1, 6};
        Arrays.sort(a);
        int index = Arrays.binarySearch(a, 6);
        System.out.println(index);
    }
    public void printArr(Object[] a) {
        System.out.println("-----------------");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }

}
