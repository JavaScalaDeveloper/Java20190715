package Reflect.Test;

/*
@author 黄佳豪
@create 2019-07-29-16:02
*/
@SuppressWarnings("all")
public class Student extends Person{
    private String name;
    int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, double score, int id) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", id=" + id +
                ", nation='" + nation + '\'' +
                '}';
    }

    protected  double score;
    public int id;
    public static final String school = "加里敦大学";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("this is setAge method");
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getSchool() {
        return school;
    }
}

class Person {
    public String nation;
    private double height;
}