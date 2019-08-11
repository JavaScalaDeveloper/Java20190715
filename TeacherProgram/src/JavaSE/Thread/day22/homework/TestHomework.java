package Thread.day22.homework;

import java.io.File;

/**
 * 使用递归实现，删除一个指定目录（不管里面有无子级）
 * @author liyuting
 *
 */
public class TestHomework {
	
	public static void main(String[] args) {
		
//		File file = new File("E:\\demo");
//		
//		deleteDirectory(file);
		System.out.println(jiecheng(100));
		
	}

	private static void deleteDirectory(File file) {
		boolean delete = file.delete();//demo
		
		if(!delete){
			File[] listFiles = file.listFiles();//a
			
			for (File subFile : listFiles) {
				deleteDirectory(subFile);
			}
			
			file.delete();
			
		}
	}
	
	public static long jiecheng(int num){
		if(num==1)
			return 1;
		return num*jiecheng(num-1);
	}

}
