package Reflect.Test;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
@author 黄佳豪
@create 2019-07-30-16:30
*/
public class GetMethodAndConstructor {
    /**
     * 获取File类所有方法
     * @throws ClassNotFoundException
     */
    @Test
    public void tset1() throws ClassNotFoundException {
        Class<?> c = Class.forName("java.io.File");
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            StringBuilder builder = new StringBuilder("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                builder.append(parameterTypes[i].getSimpleName());
                if (i == parameterTypes.length - 1) {
                    continue;
                }
                builder.append(",");
            }
            builder.append(")");
            System.out.println(methodName+builder);

        }
    }

    @Test
    public void test3() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("java.io.File");
        Constructor<?> con = c.getConstructor(String.class);
        Object o = con.newInstance("G://myNew.txt");
        Method method = c.getMethod("createNewFile");
        method.setAccessible(true);
        Object returnValue = method.invoke(o);
        System.out.println(returnValue);
    }
}
