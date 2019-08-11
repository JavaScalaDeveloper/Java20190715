package Thread.day22.exec1;

import java.util.Scanner;

/**
 * 
在main方法中创建并启动两个线程。
第一个线程循环随机打印100以内的整数，直到第二个线程从键盘读取了“Q”命令。

 * @author liyuting
 *
 */
public class TestStop {
	
	public static void main(String[] args) {
		MyThread1 m1 = new MyThread1();
		MyThread2 m2 = new MyThread2(m1);
		
		m1.start();
		m2.start();
		
	}

}

class MyThread2 extends Thread{
	Scanner input = new Scanner(System.in);
	MyThread1 m ;
	public MyThread2(MyThread1 m){
		this.m=m;
	}
	
	@Override
	public void run() {
		
		while(true){
			System.out.println("请输入：");
			char key = input.next().toUpperCase().charAt(0);
			if(key=='Q'){
				
				//中断MyThread1（通过MyThread1对象调用setFlag方法）
				m.setFlag(false);
				//本身线程停止
				break;
			}
			
		}
	}
	
}

class MyThread1 extends Thread{
	boolean flag =true;
	
	public void run() {
		
		while(flag){
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int num = (int)(Math.random()*100);
			System.out.println("随机数："+num);
		}
		
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	};

}