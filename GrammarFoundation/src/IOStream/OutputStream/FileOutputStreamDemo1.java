package IOStream.OutputStream;

import javafx.beans.binding.When;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
@author 黄佳豪
@create 2019-07-26-14:47
*/
public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("GrammarFoundation\\src\\IOStream\\File\\file1.txt");
//        FileOutputStream fos = new FileOutputStream("GrammarFoundation\\src\\IOStream\\File\\file2.txt");
        FileInputStream fis = new FileInputStream("GrammarFoundation\\src\\IOStream\\File\\cherry.jpg");
        FileOutputStream fos = new FileOutputStream("GrammarFoundation\\src\\IOStream\\File\\cherry2.jpg");
//        fis.getBytes();
        byte[] buf = new byte[1024];
        int len;
        while ((len = fis.read(buf)) != -1) {
            fos.write(buf,0,len);
        }
        fos.write("hello:\r\n早上好！".getBytes());
        fos.close();
        fis.close();
    }
}
