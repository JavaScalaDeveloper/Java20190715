package Reflect.Homework;

import java.lang.reflect.Field;

/*
利用通过反射修改私有成员变量
	定义PrivateTest类，有私有name属性，并且属性值为hellokitty，只提供name的getName的公有方法
	创建带有main方法ReflectTest的类，利用Class类得到私有的name属性
	修改私有的name属性值，并调用getName()的方法打印name属性值
@author 黄佳豪
@create 2019-07-29-20:42
*/
public class Hw1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        PrivateTest p = new PrivateTest();
// 获取对象的Class
        Class<? extends PrivateTest> c = p.getClass();
// 获取对象的私有属性
        Field name = c.getDeclaredField("name");
        //爆破
        name.setAccessible(true);
        //设置name的私有属性
        name.set(p, "ls");
        System.out.println(name.get(p));
    }
}

class PrivateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }

}