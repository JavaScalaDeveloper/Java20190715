package Reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/*
@author 黄佳豪
@create 2019-07-29-17:47
*/
public class ReflectDemo2 {
    @Test
    public void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> c = Class.forName("Reflect.Test.Student");
        Object o = c.newInstance();
        System.out.println(o.toString());
    }

    @Test
    public void test2() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("Reflect.Test.Student");
        Constructor<?> constructor = c.getDeclaredConstructor(String.class, int.class);
        //暴力拆解
        constructor.setAccessible(true);
        Object o = constructor.newInstance("zs", 12);
        System.out.println(o);
    }
}
