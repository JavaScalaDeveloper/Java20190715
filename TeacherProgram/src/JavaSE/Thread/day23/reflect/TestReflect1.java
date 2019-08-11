package Thread.day23.reflect;

import org.junit.Test;

/**
 * 此类用于演示获取Class类的对象的几种方式
 * @author liyuting
 *案例：获取String类的Class类对象
 */
public class TestReflect1 {
	//方式一：
	@Test
	public void test1() throws ClassNotFoundException {
		Class c1 = Class.forName("java.lang.String");
		
		
		System.out.println(c1.getName());
		System.out.println(c1.getSimpleName());
		
		
	}
	
	//方式二
	@Test
	public void test2() {
		
		String s = "朱华雪";
		
		Class c2 = s.getClass();
		
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());
		
		

	}
	//方式三
	@Test
	public void test3() {
		
		Class c3 = String.class;
		
		System.out.println(c3.getName());

	}
	
	
	public void method(Class c){
		
	}

}
