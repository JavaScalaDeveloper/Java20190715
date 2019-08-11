package Java8.Homework;

import org.junit.Test;

/*
@author 黄佳豪
@create 2019-07-31-10:29
*/
public class Hm1 {
    @Test
    public void test1() {
      /*  method(new A() {
            @Override
            public String getValue(String str) {
                return str.toUpperCase();
            }
        },"hello");*/
        System.out.println(method(str -> str.toUpperCase(),"hello"));
    }

    @Test
    public void test2() {
        System.out.println(method(new A() {
            @Override
            public String getValue(String str) {
                return str.substring(1,4);
            }
        },"hello"));
        System.out.println(method(str -> str.substring(1,4),"hello"));
    }
    public String method(A a,String str) {
        return a.getValue(str);
    }

    public Long fun(B<Long, Long> b, long l1, long l2) {
        return b.method(l1, l2);
    }

    @Test
    public void test3() {
        System.out.println(fun((t1,t2)->t1+t2,100l,200l));
    }
}
interface B<T, R>{
    R method(long l1, T t);
}

interface A {
    public String getValue(String str);
}