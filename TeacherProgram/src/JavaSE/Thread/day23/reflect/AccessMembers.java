package Thread.day23.reflect;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;



/**
 * 
 * 此类用于演示通过反射访问属性和方法
 * 
 * 
 * 
 * Class：
 * 		getField(String name):根据属性名获取属性对象(只能获取public修饰的，包含父类继承来的)
 * 		getDeclaredField(String name):根据属性名获取属性对象（可以获取本类定义的所有的，不问修饰符）
 * 		getMethod(String name,Class...class):根据方法名和参数列表获取方法对象(只能获取public修饰的，包含父类继承来的)
 * 		getDeclaredMethod(String name,Class...class):根据方法名和参数列表获取方法对象（可以获取本类定义的所有的，不问修饰符）
 * 
 * 
 * Field：
 * 
 * 		set(对象，新值)
 * 		get(对象)
 * 		setAccessible(true)
 * 
 * 		注意：如果是静态属性，对象更改为null即可
 * 
 * Method：
 * 		invoke(对象，Object...obj)
 * 		setAccessible(true)
 * 
 * 		
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *
 */
public class AccessMembers {
	Class c;
	@Before
	public void before() throws ClassNotFoundException{
		 c = Class.forName("com.atguigu.bean.Student");
	
	}
	
	
	//访问方法
	/*
	 * public void setAge(int age) {
	 * protected int getAge() {
	 */

	@Test
	public void test2() throws Exception {
		
		//1.根据方法名和参数列表获取方法对象
		
//		c.getMethod(name, parameterTypes) //只能获取public修饰的方法，包含从父类继承来的，不限于直接父类
		Method method = c.getDeclaredMethod("getAge");//获取本类中定义的所有方法，不问修饰符
		
		method.setAccessible(true);
		
		//2.创建对象
		
//		Object obj = c.newInstance();
		
		
		//3.调用方法
		
		Object returnValue = method.invoke(null);
		System.out.println("返回值："+returnValue);
	}
	
	
	
	
	//访问属性
	@Test
	public void test1() throws Exception {
		//1.根据属性名获取属性对象
//		Field filed = c.getField(name);  //只能获取public修饰的属性，包含从父类继承来的，不限于直接父类
		Field field = c.getDeclaredField("name");
		
		
		field.setAccessible(true);
		
		//2.获取对应类的对象
		Object obj = c.newInstance();
		
		//3.为属性赋值
		field.set(obj, "慕容复");
		
		//4.读取属性
		Object value = field.get(obj);
		System.out.println(value);
		
		
		//-----------------------练习------------------
		System.out.println(field.get(c.newInstance()));

	}
	
	//访问静态属性
	@Test
	public void exec1() throws Exception {
		//1.根据属性名获取属性对象
		Field field = c.getDeclaredField("SCHOOL");
		
		//2.暴破
		field.setAccessible(true);
		
		//3.为属性赋值
//		field.set(null, "北京大学");
		
		//4.访问属性
		
		System.out.println(field.get(null));
		

	}

}
