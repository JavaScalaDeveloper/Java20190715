package Thread.day22.demo2;
/**
 * 此类用于演示线程的常见方法三：
 * @author liyuting
 * setPriority:设置优先级 1_10  
 * getPriority：获取优先级
 *
 */
public class TestThreadMethod3 {
	
	public static void main(String[] args) {
		PriorityDemo pd1 = new PriorityDemo("A");
		pd1.setPriority(Thread.MAX_PRIORITY);
		pd1.start();
		
		
		PriorityDemo pd2 = new PriorityDemo("B");
		pd2.setPriority(Thread.MIN_PRIORITY);
		pd2.start();
		
		
		PriorityDemo pd3 = new PriorityDemo("C");
		pd3.setPriority(Thread.NORM_PRIORITY);
		pd3.start();
		
	}

}
class PriorityDemo extends Thread{
	
	
	public PriorityDemo(String name) {
		super(name);
	}

	@Override
	public void run() {
		
		for(int i=1;i<=100;i++){
			System.out.println(Thread.currentThread()+"-----"+i);
		}
	}
	
}