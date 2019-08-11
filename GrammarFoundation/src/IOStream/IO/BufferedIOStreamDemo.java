package IOStream.IO;

import java.io.*;

/*
@author 黄佳豪
@create 2019-07-26-16:00
*/
public class BufferedIOStreamDemo {
    public static void main(String[] args) throws Exception {
        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream("GrammarFoundation\\src\\IOStream\\File\\cherry.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("GrammarFoundation\\src\\IOStream\\File\\cherry3.jpg"));
        int len;
        byte[] b = new byte[1024];
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        bos.close();
    }
}
