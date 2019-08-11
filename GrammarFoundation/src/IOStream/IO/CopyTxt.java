package IOStream.IO;

import com.sun.org.apache.regexp.internal.RE;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
@author 黄佳豪
@create 2019-07-26-15:48
*/
public class CopyTxt {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("GrammarFoundation\\src\\IOStream\\File\\FileWriter1.txt");
        FileWriter fw = new FileWriter("GrammarFoundation\\src\\IOStream\\File\\fw1.txt");
        char[] chs = new char[1024];
        int len;
        while ((len = fr.read(chs)) != -1) {
            fw.write(chs, 0, len);
        }
        fw.close();
        fr.close();
    }
}
