package JavaCoreAPI.StringClass;

import java.util.Scanner;

/*
@author 黄佳豪
@create 2019-07-23-10:19
*/
public class StringBufferTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("input goods name:");
        String name = input.next();
        System.out.println("input goods price:");
        double price=input.nextDouble();
        String s = String.valueOf(price);
        StringBuffer buffer=new StringBuffer(s);
        int index = buffer.indexOf(".");
        for (int i = index-3; i >0; i-=3) {
            buffer.insert(i, ",");
        }
        System.out.println(name+"\t"+buffer);
    }
}
