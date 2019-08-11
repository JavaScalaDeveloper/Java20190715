package Reflect;

import Collection.CollectionUtils;
import org.junit.Test;
import sun.java2d.pipe.SpanIterator;

/*获取class对象的三种方式
@author 黄佳豪
@create 2019-07-29-15:48
*/
public class RequireClass {
    @Test
    public void test1() throws ClassNotFoundException {
        Class<?> c1 = Class.forName("java.lang.String");
        System.out.println(c1.getClasses());
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());
    }

    @Test
    public void test2() {
        String s = "zs";
        Class<? extends String> c2 = s.getClass();
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());
    }

    @Test
    public void test3() {
        Class<String> c = String.class;
        System.out.println(c.getName());
    }
}
