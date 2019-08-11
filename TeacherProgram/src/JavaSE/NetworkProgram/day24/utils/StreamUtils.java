package NetworkProgram.day24.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 此类用于封装一个IO流读写的工具类
 * @author liyuting
 *
 */
public class StreamUtils {
	
	/**
	 * 功能：将字节输入流读取后，转换成String
	 * @param is
	 * @return
	 * @throws IOException 
	 */
	public static String streamToString(InputStream is) throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder builder=new StringBuilder();
		String line;
		while((line=reader.readLine())!=null){
			builder.append(line);
			
		}
		
		return builder.toString();
		
	}
	
	/**
	 * 功能：将字节输入流读取后，转换成byte[]
	 * @param is
	 * @return
	 * @throws IOException 
	 */
	public static byte[] streamToByteArray(InputStream is) throws IOException{
		ByteArrayOutputStream  baos = new ByteArrayOutputStream();
		int len;
		byte[] b = new byte[1024];
		while((len=is.read(b))!=-1){
			baos.write(b, 0, len);
			
		}
		
		return baos.toByteArray();
		
		
		
	}
	

}
