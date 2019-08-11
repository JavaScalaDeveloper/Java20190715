package Object.InnerClass;

/*
@author 黄佳豪
@create 2019-07-21-11:44
*/
public class LocalInner {

}

class Outer3 {
   private String name;

    public void print() {
//        new Inner3()
        method();
    }
    public void method() {
        class Inner3 {
            String color;

            {

            }

            public Inner3() {

            }

            class InnerInner3 {
            }
//static String no;
            public void show() {

                System.out.println(name);
            }
        }
//        static不能有static修饰符
        Inner3 i=new Inner3();
    }

}