package Object.Abstract;

/*
@author 黄佳豪
@create 2019-07-20-19:16
*/
public class InterfaceDemo {
    public static void main(String[] args) {
        Flyer f=new Flyer();
        f.toString();
    }
}

interface Fly {
    String name = "zs";//全是静态常量

    void fly();


}

class Flyer implements Fly{
//    Flyer f=new Flyer();

    @Override
    public void fly() {

    }
}

abstract class Bird implements Fly{
    //可以不实现抽象方法
}