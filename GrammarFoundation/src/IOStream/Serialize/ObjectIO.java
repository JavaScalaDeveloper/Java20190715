package IOStream.Serialize;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
@author 黄佳豪
@create 2019-07-26-19:38
*/
public class ObjectIO {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("GrammarFoundation\\\\src\\\\IOStream\\\\File\\1.txt"));
        oos.writeInt(100);
        oos.writeChar('男');
        oos.close();
    }
    @Test
    public void test() throws IOException {

    }
}
