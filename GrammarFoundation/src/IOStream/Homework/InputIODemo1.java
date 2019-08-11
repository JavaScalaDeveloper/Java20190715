package IOStream.Homework;

import javax.xml.crypto.KeySelector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
@author 黄佳豪
@create 2019-07-27-14:37
*/
public class InputIODemo1 {
    public static void main(String[] args) throws IOException {
        System.out.print("insert name:");
        String s = MyInput.readString();
        System.out.print(s+"insert age:");
        int i = MyInput.readInt();
        System.out.println(s+"\t"+i);
    }
}

class MyInput {
    public static String readString() throws IOException {
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        return line;
    }

    public static int readInt() throws IOException {
        int num = Integer.parseInt(readString());
        return num;
    }
}