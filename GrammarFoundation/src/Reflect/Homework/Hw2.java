package Reflect.Homework;

import Reflect.ReflectUtils;

import java.io.File;

/*
利用反射和File完成以下功能
	获取File类中的所有方法和构造器
	利用Class类的forName方法得到File类（）
	通过newInstance的方法创建File对象，并创建D：\mynew.txt文件
@author 黄佳豪
@create 2019-07-29-20:42
*/
public class Hw2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> f = Class.forName("java.io.File");
        //获取方法和构造器
        ReflectUtils.printMethods(f);
        ReflectUtils.printConstructors(f);
      /*  Object newFile = f.newInstance();
        File ff = new File("c://1.txt");*/
    }
}
