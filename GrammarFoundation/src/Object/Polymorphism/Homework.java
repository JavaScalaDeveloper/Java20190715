package Object.Polymorphism;

import sun.java2d.pipe.SpanIterator;

/*
@author 黄佳豪
@create 2019-07-19-22:21
1、现有Person类，里面有方法run、eat，Student类继承了Person类，并重写了run方法，
自定义了study方法,试写出对象向上转型和向下转型的代码，并写出都可以调用哪些方法
2、试定义Person数组，长度为2，里面保存一个Student对象和一个Person对象，循环遍历Person数组，如果是学生，则调用其study方法

*/
public class Homework {

}

class Homework1 {

    public static void main(String[] args) {
        Person p = new Student();
        //向下转型

        Student s = (Student) p;
        //向上转型
        s.run();
        s.study();
        Person sp = (Person) s;
        sp.run();
        sp.eat();
    }
}

class Person {
    public void run() {
        System.out.println("Person's run");
    }

    public void eat() {
        System.out.println("Person's eat");
    }
}

class Student extends Person {

    @Override
    public void run() {

        System.out.println("studnet's run");
    }

    public void study() {
        System.out.println("student study");
    }
}
