package Enum.atguigu.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException1 {
	
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner input = new Scanner(System.in);
//		int  i=input.nextInt();
//		System.out.println(i);
		
		
		
		FileInputStream fis = new FileInputStream("src\\student.txt");
	}

}
