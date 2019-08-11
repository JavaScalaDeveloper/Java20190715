package Java8.LambdaInterface;

import Object.Abstract.EmployeeDemo;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
@author 黄佳豪
@create 2019-07-31-11:17
*/
public class FunctionalInterface {
    @Test
    public void test1() {
        Consumer<Integer> con=new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                if (integer > 1) {
                    System.out.println(">1");
                } else {
                    System.out.println("<1");
                }
            }
        };
        Consumer<Integer> con2=t->{
            if (t > 1) {
                System.out.println(">1");

            } else {
                System.out.println("<1");
            }
        };
        con.accept(200);
    }

    @Test
    public void test2() {
        Supplier<String> sup=()->"john".toUpperCase();
            System.out.println(sup.get());

    }

    @Test//函数型接口Function
    public void test3() {
        Function<Double, Double> fun = d -> Math.pow(d, 2);
        System.out.println(fun.apply(100d));
    }

    @Test//判定型接口
    public void test4() {

    }

}
