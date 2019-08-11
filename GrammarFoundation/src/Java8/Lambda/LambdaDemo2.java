package Java8.Lambda;

import org.junit.Test;

import java.util.Comparator;

/*
Lambda表达式的语法和特点
@author 黄佳豪
@create 2019-07-30-21:27
*/
public class LambdaDemo2 {
    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("ls");
            }
        };
        r.run();
        Runnable r1 = () -> System.out.println("qq");
        r1.run();
    }

    @Test
    public void test2() {
        Comparator<String> c1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        //Lambda
        Comparator<String> c2 = (o1, o2) -> o1.compareTo(o2);
    }

}
