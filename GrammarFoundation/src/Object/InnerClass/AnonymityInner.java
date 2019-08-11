package Object.InnerClass;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/*
@author 黄佳豪
@create 2019-07-21-12:06
*/
public class AnonymityInner {
    public static void main(String[] args) {
        Outer4 o = new Outer4();
        o.method();
        method(new Fly() {
            @Override
            public void fly() {
                System.out.println("飞呀飞");
            }
        });
        TreeSet set=new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
    }
    @Test
    public static void method(Fly flys) {
        flys.fly();
    }
}

class Outer4 {
    String name;
int age=18;
    public void method() {
        new Fly(){//匿名内部类
            String color;

            public void show() {
                this.color = "red";
                name = "zs";
                int page=age++;
                System.out.println(color);
                System.out.println("name:"+name+",age:"+page);
            }
            @Override
            public void fly() {
                show();
                System.out.println("匿名起飞");
            }
        }.fly();//直接调方法
    }
}

interface Fly {
    void fly();
}