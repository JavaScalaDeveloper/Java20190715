package Java8.Lambda;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/*
语法：
类或对象：：方法名
@author 黄佳豪
@create 2019-07-31-14:29
*/
public class MethodRefDemo1 {
    @Test
    public void test1() {

        Consumer<String> con = s -> System.out.println(s);
        Consumer<String> con2 = System.out::println;
        con2.accept("hello");
        con.accept("he");

    }

    //类名：：静态方法
    @Test
    public void test2() {
        Comparator<Integer> com1 = (i1, i2) -> {
            return Integer.compare(i1, i2);
        };
        int i = com1.compare(1, 3);
        System.out.println(i);
        Comparator<Integer> com2=Integer::compareTo;
        com2.compare(1, 3);
    }

    //类：：普通方法
    @Test
    public void test3() {
        Comparator<String > com1=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Comparator<String> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare("1", "4"));
        //使用方法引用
        Comparator<String> com3=String::compareTo;
        System.out.println(com3.compare("1", "5"));
    }

    @Test
    public void test4() {
        BiFunction<String, String, Boolean> b1 = new BiFunction<String ,String ,Boolean>(){
            @Override
            public Boolean apply(String  o, String  o2) {
                return o.equals(o2);
            }
        };
        BiFunction<String, String, Boolean> b2 = (t, u) -> t.equals(u);
        BiFunction<String ,String, Boolean> b3=String::contains;
    }

    @Test
    public void test5() {

    }
}
