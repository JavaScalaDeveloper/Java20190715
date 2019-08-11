package Object.Polymorphism;

/*
@author 黄佳豪
@create 2019-07-19-18:10
*/
public class FatherTest {
    public static void main(String[] args) {
        Father f = new Son();
        System.out.println(f.name);//father,属性没有重写之说
        f.father();//son override father's method...
//        System.out.println(f.age);//编译错误
//        f.son()//编译报错，父类类型
    }
}

class Father {
    public String name = "father";

    public void father() {
        System.out.println("father's method...");
    }
}

class Son extends Father {
    public String name = "son";
    public int age = 19;

    @Override
    public void father() {
        System.out.println("son override father's method...");
    }

    public void son() {
        System.out.println("son's method....");
    }
}