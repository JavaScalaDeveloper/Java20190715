package JavaCoreAPI.StringClass;

import org.junit.Test;

import java.lang.reflect.Member;

/*
@author 黄佳豪
@create 2019-07-23-10:12
*/
public class StringBufferDemo2 {
    @Test
    public void test1() {
        StringBuffer s = new StringBuffer("sjklfa");
        s.append("李四").append("ds").append("ewf包青天");
        System.out.println(s + "\t" + s.delete(3, 8));
        System.out.println(s.indexOf("包青")+"\t"+s.insert(5,"32425"));

    }
}
