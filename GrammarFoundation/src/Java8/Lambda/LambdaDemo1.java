package Java8.Lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/*
@author 黄佳豪
@create 2019-07-30-21:12
*/
public class LambdaDemo1 {
    @Test
    public void test1() {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("zs");
            }
        };
        Thread t=new Thread(r);
        t.start();
        new Thread(()-> System.out.println("wjhdsb")).start();
    }

    @Test
    public void test2() {
//        TreeSet set=new TreeSet(Comparator.comparingInt(o1 -> o));
    }
}
