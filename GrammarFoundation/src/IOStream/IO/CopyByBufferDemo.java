package IOStream.IO;


import java.io.*;

/*
@author 黄佳豪
@create 2019-07-26-19:27
*/
public class CopyByBufferDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("GrammarFoundation\\\\src\\\\IOStream\\\\File\\\\file1.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("GrammarFoundation\\\\src\\\\IOStream\\\\File\\\\file4.txt"));
        //读写
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
