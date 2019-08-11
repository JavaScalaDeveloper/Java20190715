package IOStream.PrintStream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
@author 黄佳豪
@create 2019-07-27-11:13
*/
public class ConvertIO {
//    @Test
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(s);
    }
}
