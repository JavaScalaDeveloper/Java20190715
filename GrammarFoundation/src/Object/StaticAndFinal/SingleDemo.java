package Object.StaticAndFinal;

/*
@author 黄佳豪
@create 2019-07-20-12:50
*/
public class SingleDemo {
    public static void main(String[] args) {
        Single1 s1 = Single1.getInstance();
        Single1 s2 = Single1.getInstance();
        System.out.println(s1==s2);
        Single1.rate=1000;
        Single2 s22=Single2.getInstance();
    }
}

//懒汉式
class Single2 {
    private Single2() {

    }
    private static Single2 s;
//方法内部创建对象
    public static Single2 getInstance() {//后创建对象
        if (s == null) {

            s=new Single2();
        }
        return s;
    }
}
//单例模式：饿汉式
class Single1 {
    public static int rate=100;
    private Single1() {}
    private static Single1 s=new Single1();//先创建对象

    public static Single1 getInstance() {
        return s;
    }
}