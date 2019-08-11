package InnerClassAndEnum.inner;
/**
 * 此类用于演示内部类：匿名内部类的特点和使用
 * @author liyuting
 * 
 * 语法：
 * 	new 类名或接口名(参数){
 * 
 * 		类体
 * 	}
 *  创建了一个匿名内部类&创建了一个该类对象
 *  
 *  示例：
 *  
 *  new  A(){
 *  	//类体
 *  }
 *  
 *  创建A的子类&创建A的子类对象
 *  
 *  对比：
 *  new A(); 创建A本类的对象
 */
public class TestInner4 {

}

@SuppressWarnings("ALL")//用于抑制程序编译警告
class Outer4{
	
	
	String name;
	public void method(){
		//定义匿名内部类
		new Fly(){

			@Override
			public void fly() {
				// TODO Auto-generated method stub
				
			}
			
		};

		new Object();
		
		
		
	}
}

interface Fly{
	void fly();
}