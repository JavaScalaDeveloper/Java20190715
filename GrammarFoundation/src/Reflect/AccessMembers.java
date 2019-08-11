package Reflect;

import org.junit.Before;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*访问属性和方法
@author 黄佳豪
@create 2019-07-29-18:02
*/
public class AccessMembers {
    Class c;

    @Before
    public void before() throws ClassNotFoundException {
        c = Class.forName("Reflect.Test.Student");
    }

    //访问属性
    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        //根据属性名获取属性对象
        Field field = c.getDeclaredField("name");
        field.setAccessible(true);
        //获取对应类的对象
        Object o = c.newInstance();
//        为属性赋值
        field.set(o,"ls");
        //读取属性
        Object value = field.get(o);
        System.out.println(value);
    }

    /**
     * 访问属性
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void test2() throws NoSuchFieldException, IllegalAccessException {
        Field field = c.getDeclaredField("school");
        //爆破
        field.setAccessible(true);
//        为属性赋值
//        field.set(null,"beida");//static属性无法修改
//        访问属性
        System.out.println(field.get(null));
    }

    /**
     * 访问方法
     */
    @Test
    public void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //根据方法名和参数列表获取方法对象
        Method method = c.getDeclaredMethod("setAge",int.class);
        //爆破
        method.setAccessible(true);
        //创建对象
        Object obj = c.newInstance();
        //调用方法
        Object returnValue = method.invoke(obj, 100);
        System.out.println(returnValue);
    }
}
