package Object.InnerClass;


/*静态内部类对使用
@author 黄佳豪
@create 2019-07-21-11:25
*/
public class InnerDemo2
{
    public static void main(String[] args) {
        Outer2 o = new Outer2();
        int a= o.method();
        System.out.println(a);
        Outer2.Inner2 i = new Outer2.Inner2(18);
        i.show();
    }
}

class Outer2 {
   private static String name="zs";

  public static class Inner2 {
     int age;

        public void show() {
            name = "ww";
            System.out.println(name);  //直接访问外部类静态成员
        }

        class Inner {

        }
        static {}

        static class Inner3 {

        }

        public Inner2(int age) {
            this.age = age;
        }
    }
    public static int method() {
        Inner2 i = new Inner2(19);
        System.out.println(i);
        return 0;
    }
}