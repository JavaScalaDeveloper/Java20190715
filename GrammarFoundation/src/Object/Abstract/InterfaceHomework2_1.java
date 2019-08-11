package Object.Abstract;

import java.util.Scanner;

/*
@author 黄佳豪
@create 2019-07-21-17:46
有一个交通工具接口类Vehicles，有work接口，有Horse类和Boat类分别实现Vehicles，创建交通工具工厂类，
有两个方法分别获得交通工具Horse和Boat；有Person类，有name和Vehicles属性，在构造器中为两个属性赋值，
实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具。
*/
public class InterfaceHomework2_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("天气情况：1：一般。2：大河:");
//        char key = input.next().charAt(0);
        long start = System.currentTimeMillis();{
        char key = '1';
        Vehicles2 v;
        if (key == '1') {
            v = Foctory.getHorse();
        } else {
            v = Foctory.getBoat();
        }
        Person3 p = new Person3("唐僧", v);
        p.drive();
            long end = System.currentTimeMillis();
            System.out.println("耗时="+(end-start));

    }
    }
}

class Person3 {
    private String name;
    private Vehicles2 v;

    public Person3(String name, Vehicles2 v) {
        this.name = name;
        this.v = v;
    }


    public void drive() {
        v.work();
    }
}

class Foctory {
    public static Vehicles2 getHorse() {
        return new Horse2();
    }

    public static Vehicles2 getBoat() {
        return new Boat2();
    }
}

interface Vehicles2 {
    void work();

}

class Horse2 implements Vehicles2 {

    @Override
    public void work() {
        System.out.println("By boat");
    }
}

class Boat2 implements Vehicles2 {
    @Override
    public void work() {
        System.out.println("By Horse");
    }
}