package IOStream.Homework;

import java.io.FileOutputStream;
import java.io.IOException;

/*
@author 黄佳豪
@create 2019-07-27-8:54
一、试将一个byte[]写入到指定文件 src/byt.txt中
*/
public class Homework2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fo = new FileOutputStream("GrammarFoundation\\\\src\\\\IOStream\\\\File\\file5.txt");
        byte[] buf = new byte[]{'a','b','d','d'};

//        buf={'s','f','g'};
        fo.write(buf);
        fo.close();
    }
}
