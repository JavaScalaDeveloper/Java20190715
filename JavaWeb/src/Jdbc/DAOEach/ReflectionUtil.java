package Jdbc.DAOEach;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author 黄佳豪
 * @create 2019-08-04-11:16
 */
public class ReflectionUtil {
    /**
     * 获取形参clazz的父类的泛型
     * @param clazz
     * @return
     */
    public static Class getGericParam(Class clazz) {
        Type type = clazz.getGenericSuperclass();//获取带泛型的父类
        ParameterizedType paramType= (ParameterizedType) type;
        Type[] typeArguments = paramType.getActualTypeArguments();
        return (Class) typeArguments[0];
    }
}
