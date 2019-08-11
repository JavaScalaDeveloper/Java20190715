package Reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*演示获取类中其他结构：包、父类、接口、泛型、注解
@author 黄佳豪
@create 2019-07-29-16:45
*/

public class ReflectUtils2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c = Class.forName("Reflect.Test.Student");//包名+类名不要.class和.java
        printPackege(c);
        printSuperClass(c);
        printInterfaces(c);
//        printSuperClass(c);
        printAnnotation(c);
    }

    /**
     * 获取包
     *
     * @param c
     */
    public static void printPackege(Class c) {
        System.out.println(c.getPackage().getName());
    }

    /**
     * 获取直接父类
     *
     * @param c
     */
    public static void printSuperClass(Class c) {
        System.out.println(c.getSuperclass().getSimpleName());
    }

    /**
     * 获取实现的所有接口
     *
     * @param c
     */
    public static void printInterfaces(Class c) {
        Class[] interfaces = c.getInterfaces();
        for (Class inter : interfaces) {
            System.out.println(inter.getSimpleName());
        }
    }

    /**
     * 获取父类的泛型
     *
     * @param c
     */
    public static void printGenericSupperClass(Class c) {
        Type genericSuperclass = c.getGenericSuperclass();//父类类型+泛型类型
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return;
        }
        ParameterizedType pt = (ParameterizedType) genericSuperclass;
        Type[] genericTypes = pt.getActualTypeArguments();
        Class genericT = (Class) genericTypes[0];
        System.out.println(genericT.getTypeName());
    }

    /**
     * 获取注解
     *
     * @param c
     */
    public static void printAnnotation(Class c) {
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getSimpleName());
        }
    }

    /*    *//**
     * 获取父类的泛型
     *
     * @param c
     *//*
    public static void printGenericInterfaces(Class c) {
        Type genericSuperclass = c.getGenericSuperclass();//父类类型+泛型类型
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return;
        }
        ParameterizedType pt = (ParameterizedType) genericSuperclass;
        Type[] genericTypes = pt.getActualTypeArguments();
        Class genericT = (Class) genericTypes[0];
        System.out.println(genericT.getTypeName());
    }*/

}
