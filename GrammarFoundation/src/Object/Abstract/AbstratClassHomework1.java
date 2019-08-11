package Object.Abstract;

/*1：按要求实现下列问题：实现一个名为Person的类(抽象)和它的子类Employee，Employee有两个子类Faculty和Staff。具体要求如下：
1）	Person类中的属性有：姓名name（String类型），地址address（String类型），
；
2）	Employee类中的属性有：办公室office（String类型，静态修饰），工资wage（double
类型），受雇日期hiredate（String类型），公司（final修饰，String compamy属性）
初始化块中为公司赋值：XX大公司
3）	Faculty类中的属性有：学位degree（String类型，静态修饰），级别level（String类型）；
4）	Staff类中的属性有：职务称号duty（String类型）。
5）	现有对象Person p1 =new Faculty()和Person p2 =new Staff ()，请分别为p1的属性赋值“本科”和Staff类的duty赋值“职员”
将p1和p2 都放在Person数组，中，循环打印里面的属性信息！

@author 黄佳豪
@create 2019-07-21-8:02
*/
public class AbstratClassHomework1 {
    public static void main(String[] args) {
        Person1 p1 = new Faculty();
//        Faculty p11 = (Faculty) p1;
        p1.degree="本科";
        Person1 p2 = new Staff();
        p2.duty = "职员";
        Person1[] p = new Person1[2];
        p[0]=p1;
        p[1]=p2;
        for (int i = 0; i < p.length; i++) {

            System.out.println(p[i].toString());
        }
    }
}

abstract class Person1 {
    String name;
    String address;
 static String degree;
 static String duty;

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class Employee1 extends Person1 {
    static String office;
    double wage;
    String hiredate;
    final String company = "xx大公司";
}

//Faculty类中的属性有：学位degree（String类型，静态修饰），级别level（String类型）；
class Faculty extends Employee1 {
    static String degree;
    String level;

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", degree='" + degree + '\'' +
                ", duty='" + duty + '\'' +
                '}';
    }

    public void Faculty(String degree) {

    }
}

//Staff类中的属性有：职务称号duty（String类型）。
class Staff extends Faculty {
   static String duty;



    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", degree='" + degree + '\'' +
                ", duty='" + duty + '\'' +
                '}';
    }


}