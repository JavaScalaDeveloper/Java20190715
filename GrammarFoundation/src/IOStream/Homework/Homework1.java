package IOStream.Homework;

import java.io.*;

/*1、（字符流+缓冲流）读取一个文本文件，每行都追加一个“好”，在文件结尾再追加“完毕”。
@author 黄佳豪
@create 2019-07-27-7:52
*/
public class Homework1 {
    public static void main(String[] args) throws IOException {
        //创建字符流缓冲对象
        InputStreamReader ir = new InputStreamReader(new FileInputStream("GrammarFoundation\\\\src\\\\IOStream\\\\File\\file1.txt"));
        BufferedWriter bf = new BufferedWriter(new FileWriter("GrammarFoundation\\\\src\\\\IOStream\\\\File\\file5.txt"));
        byte[] buf = new byte[1024];
        int len;
        while ((len = ir.read()) != -1) {
//            bf.write();
            bf.write(buf+""+"好\r\n");
            if (len == 0) {
                bf.write("完毕");
            }
        }
        bf.close();ir.close();
    }
}
