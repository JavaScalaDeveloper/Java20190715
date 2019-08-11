package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
@author 黄佳豪
@create 2019-07-29-15:56
*/
@SuppressWarnings("all")
public class ReflectUtils {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c = Class.forName("Reflect.Test.Student");//包名+类名不要.class和.java
        printFields(c);
//        printMythods(c);
//        printConstructors(c);
    }

    /**
     * 通过反射获取对应类所有属性
     *
     * @param c Class类的对象
     */
    public static void printFields(Class c) {
//        Field[] fields = c.getFields();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            //修饰符、
            int mod = field.getModifiers();
            String modifier = Modifier.toString(mod);
            // 属性类型。
            String typeName = field.getType().getSimpleName();
            // 顺序名
            String name = field.getName();
            System.out.println(modifier + "\t" + typeName + "\t" + name);
        }
    }

    /**
     * 通过反射获取所有方法
     * @param c
     */
    public static void printMethods(Class c) {
        //获取所有方法
//        Method[] methods  = c.getMethods();//包含从父类继承的所有public方法
        Method[] methods = c.getDeclaredMethods();//本类中定义的所有方法
//        遍历每个方法，打印每个方法签名四要素
        for (Method method : methods) {
//            修饰符
            String modifier = Modifier.toString(method.getModifiers());
//                    返回类型
            String returnTypeName = method.getReturnType().getSimpleName();
//            方法名
            String name = method.getName();
//                    参数列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringBuilder builder = new StringBuilder("(");
            for (int i = 0; i < parameterTypes.length; i++) {
                String simpleName = parameterTypes[i].getSimpleName();
                builder.append(simpleName);
                if (i == parameterTypes.length - 1) {
                    continue;
                }
                builder.append(',');
            }
            builder.append(")");
            System.out.println(modifier+"\t"+returnTypeName+"\t"+name+builder);
        }
    }

    /**
     * 通过反射打印所有的构造器
     * @param c
     */
    public static void printConstructors(Class c) {
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            //修饰符
            String modifier = Modifier.toString(constructor.getModifiers());
            //方法名
            String name = c.getSimpleName();
            //参数列表
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            StringBuilder builder = new StringBuilder("(");
            for (int i = 0; i < parameterTypes.length; i++) {
                String simpleName = parameterTypes[i].getSimpleName();
                builder.append(simpleName);
                if (i == parameterTypes.length - 1) {
                    continue;
                }
                builder.append(',');
            }
            builder.append(")");
            System.out.println(modifier+"\t"+name+builder);
        }
    }
}
