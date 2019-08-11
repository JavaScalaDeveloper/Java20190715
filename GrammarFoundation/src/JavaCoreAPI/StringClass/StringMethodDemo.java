package JavaCoreAPI.StringClass;

import org.junit.Test;

/*
@author 黄佳豪
@create 2019-07-22-22:30
*/
public class StringMethodDemo {
    @Test
    public void test() {
        String name = "3242234kj25";
        System.out.println(name.substring(3));
        System.out.println(name.substring(3,6));
        String ns = name.replace("23", "34334");
        System.out.println(ns);
        String[] split = ns.split("2");
        for (int i = 0; i < split.length; i++) {
            System.out.print(split[i]+"\t");
        }
    }
}
