package Reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/*通过反射观察泛型的本质
@author 黄佳豪
@create 2019-07-30-16:20
*/
public class AbserverAnnotationByReflect {
    @Test
    public void test1() {
        List list = new ArrayList<>();
        list.add("zs");
        list.add(100);
        List<String > list2 = new ArrayList<>();//泛型在编译结束被擦除，运行时不存在
        list2.add("zs");
        System.out.println(list.getClass()==list2.getClass());//true
    }

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Object> list = new ArrayList<>();
        Class<? extends ArrayList> c = list.getClass();
//        Method method = c.getMethod("add", String.class);//运行期间无法判断类的泛型，运行报错
        Method method = c.getMethod("add", Object.class);
        method.invoke(list, "zs");
    }
}
