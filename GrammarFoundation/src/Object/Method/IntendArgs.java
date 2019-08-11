package Object.Method;

import javax.xml.bind.SchemaOutputResolver;

/*演示传参
@author 黄佳豪
@create 2019-07-18-19:54
*/
public class IntendArgs {
    public static void main(String[] args) {
        MethodUtils2 p = new MethodUtils2();
        Person p1 = new Person();
        p.method(p1);
        p1.name = "张无忌";
        System.out.println(p1.name + "---p1的name没受影响,因为传值");
        System.out.println("-----传参------");
        MethodUtils2 p_ = new MethodUtils2();
        Person p1_ = new Person();
        p1_.name = "张无忌";
        p_.method(p1_);
        System.out.println(p1_.name + "---p1_的name受影响，因为传地址");

    }
}

class MethodUtils2 {
    public void method(Person person) {
//        new Person();//新建了一个对象
        person.name = "join";
        System.out.println("-------" + person.name);
    }
}

class Person {
    String name;
}