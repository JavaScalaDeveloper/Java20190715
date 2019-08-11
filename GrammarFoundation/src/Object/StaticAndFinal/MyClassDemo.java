package Object.StaticAndFinal;

/*
@author 黄佳豪
@create 2019-07-20-17:52
*/
public class MyClassDemo {
    static int x,y;
    {int x;}
    static {int x=5;x--;}//此处的int与前面的不同
//    static {x=5;x--;}//输出结果为15
    static {x--;}

    public static void main(String[] args) {
        x--;
        myMethod();
        System.out.println(x+y + ++x);//-1
    }
    public static void myMethod() {
        y=x++ + ++x;
    }

}
