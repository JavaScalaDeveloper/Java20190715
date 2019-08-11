package IOStream.IO;

import sun.java2d.pipe.SpanIterator;

import java.awt.*;
import java.io.*;

/*
@author 黄佳豪
@create 2019-07-26-16:09
*/
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("GrammarFoundation\\src\\IOStream\\File\\file1.txt"));
        String line;
        BufferedWriter bw = new BufferedWriter(new FileWriter("GrammarFoundation\\src\\IOStream\\File\\file1.txt")        );
        bw.newLine();
         while ((line = br.readLine()) != null) {

            System.out.println(line);
        }
        bw.write("helloword");
    }
}
