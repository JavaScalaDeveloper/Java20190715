package Object.Filed;

import org.junit.Test;

import java.security.Permission;
import java.security.PublicKey;

/*
@author 黄佳豪
@create 2019-07-18-11:37
*/
public class Person {
    public static void main(String[] args) {
        String name;
        int age;
        Person p = new Person();
        p.say();

        new Person().say();
        Student s = new Student();
        s.name = "zs";
        s.age = 19;
        System.out.println(s.toString());
    }
@Test
    public void say() {

        System.out.println("说话。。。");
    }
}

class Student {

    String name;
    int age;
    public void say() {
        System.out.println("student can speak english...");
    }

    @Override
    public String toString() {
        Student s = new Student();
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +"say:"+
                '}';
    }
}