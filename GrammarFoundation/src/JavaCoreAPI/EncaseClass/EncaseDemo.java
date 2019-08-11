package JavaCoreAPI.EncaseClass;

import org.junit.Test;

/*
@author 黄佳豪
@create 2019-07-22-21:14
*/
public class EncaseDemo {

    @Test//基本->包装
    public void test1() {
        int i=100;

        Integer I = new Integer(i);

        System.out.println(++I);
    }

    @Test//装箱->基本
    public void test2() {
        Integer i = new Integer(100);
        int j=i.intValue();
        System.out.println(i+j);
    }

    @Test
    public void test3() {
        Character c = new Character('c');
        char c2=c;
        System.out.println(c);
    }
}
