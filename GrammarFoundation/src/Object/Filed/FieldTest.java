package Object.Filed;


/*
@author 黄佳豪
@create 2019-07-18-14:21
*/
public class FieldTest {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.name = "bm001";
        Car c2 = new Car();
        c2.name = "w2w";
        System.out.println(c1.name + "\t" + c2.name);
        new Car().age(13);
        TempratureMachine t = new TempratureMachine();
        t.getArea();
        t.print();
        t.getArea2(10, 3);
        t.isOdd(234324235);
        t.printRect(12, 2, 12, "huangjiahao");
        t.getClass();
    }
}

class Car {
    String name;
    TempratureMachine tm;//对象关联

    public void start() {
        return;
    }

    public void stop() {

    }

    public int age(int age) {
        System.out.println("age="+age);
        return age;//必须有返回值
    }
}

class TempratureMachine {
    //无反无参
    public void print() {
        System.out.println("-------");
    }

    //又返回无参
    public double getArea() {
        int hang = 10;
        int lie = 8;
        return hang * lie;
    }

    public void printRect(int hang, int lie,int sum, String str) {
        for (int i = 1; i <= hang; i++) {
            for (int j = 1; j <= lie; j++) {
                System.out.println(str);
                sum = i * j;
            }
            System.out.println(sum);
        }
    }

    //有返回有参
    public double getArea2(int hang, int lie) {
        return hang*lie;
    }

    //  判断奇偶数
    public boolean isOdd(int a) {
        return a % 2 == 0;
    }
}