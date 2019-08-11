package Object.InnerClass;



/*
@author 黄佳豪
@create 2019-07-21-10:58
*/
public class InnerDemo1 {
    public static void main(String[] args) {
        OtherClass.Inner i = new OtherClass.Inner();
        i.show();
    }
}

class OtherClass {
   private static String  name;

    static class Inner {
        class InnerInner {
            public InnerInner(int age) {
                this.age = age;
            }

            @Override
            public String toString() {
                return "InnerInner{" +
                        "age=" + age +
                        '}';
            }


            int age;
        }

        public void show() {
            name = "zs";
            System.out.println(new InnerInner(10));
            String s = new InnerInner(15).toString();
            System.out.println(s);
            System.out.println(name);
        }
    }

    public void method() {

    }
}
