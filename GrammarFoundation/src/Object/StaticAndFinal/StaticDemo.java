package Object.StaticAndFinal;

/*
@author 黄佳豪
@create 2019-07-20-11:02
*/
public class StaticDemo {
    public static void main(String[] args) {
        System.out.println(A.name);
        A a1 = new A("zhongguo");
        a1.name = "sa ";
        System.out.println(a1);
        A a2 = new A("meiguo");
        a2.name = "sb ";
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(A.name);
        System.out.println("--------method and static methond----------");
        a1.method();
        A.staticMethod();
    }
}

class A {
    static String name;//也成为类属性
    String nation;

    public A() {
    }

    @Override
    public String toString() {
        return "A{" + name +
                "nation='" + nation + '\'' +
                '}';
    }

    public A(String nation) {
        this.nation = nation;
    }

    public void method() {
        System.out.println("I am ganeral method.");
    }
    public static void staticMethod() {
        System.out.println("I am static method.");
    }
}