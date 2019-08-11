package IOStream.OutputStream;

import java.io.FileWriter;
import java.io.IOException;

/*
@author 黄佳豪
@create 2019-07-26-15:41
*/
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("GrammarFoundation\\src\\IOStream\\File\\FileWriter1.txt");
        fw.write('中');
        fw.write("张三".toCharArray());
        fw.write("李四啊".toCharArray(),2,1);
        fw.close();
    }
}
