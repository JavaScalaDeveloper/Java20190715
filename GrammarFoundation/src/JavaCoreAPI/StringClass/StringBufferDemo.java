package JavaCoreAPI.StringClass;

import org.junit.Test;
import sun.font.TrueTypeFont;

/*
@author 黄佳豪
@create 2019-07-22-22:58
*/
public class StringBufferDemo {
    @Test
    public void test() {
        StringBuffer sb = new StringBuffer();
        sb.append("as");
        sb.append(true);
        sb.append(100);
        sb.append(1232432413532141l);
        System.out.println(sb);
        System.out.println(sb.length());
        //StringBuffer>String transform
        String st= String.valueOf(sb);
        String st2=sb.toString();
        //String>StringBuffer transform
        StringBuffer sb2 = new StringBuffer(st);
    }
}
