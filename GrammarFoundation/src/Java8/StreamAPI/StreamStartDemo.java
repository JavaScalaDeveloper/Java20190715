package Java8.StreamAPI;

import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
@author 黄佳豪
@create 2019-07-31-15:40
*/
public class StreamStartDemo {
    @Test
    public void test1() {
        List<Employee1> list = EmployeeData.getEmployees();
        //获取串行流对象
        Stream<Employee1> stream = list.stream();
        //获取并行流对象
        Stream<Employee1> employee1Stream = list.parallelStream();
        /*stream.forEach(new Consumer<Employee1>() {
            @Override
            public void accept(Employee1 employee1) {
                System.out.println(employee1);
            }
        });*/
        //使用Lambda
        stream.forEach(employee1 -> System.out.println(employee1));
    }

    @Test
    public void test2() {
        String[] s = {"sa","gf"};
        Stream<String> stream = Arrays.stream(s);
        stream.forEach(System.out::println);
    }

    @Test
    public void test3() {
        Stream.of('a', 'b', 'c').forEach(System.out::println);
    }

    @Test
    public void test4() {
        //生成无限流
        Stream<Double> generate = Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        });
        Stream<Double> generate1 = Stream.generate(() -> Math.random());
        Stream<Double> generate2 = Stream.generate(Math::random);
        generate2.forEach(System.out::println);
    }
}
class EmployeeData {
    public static List<Employee1> getEmployees() {
        List<Employee1> list = new ArrayList<>();
        list.add(new Employee1("zs", 18, 11111, '男'));
        list.add(new Employee1("wq", 43, 2234, '男'));
        list.add(new Employee1("zl", 24, 5431, '男'));
        list.add(new Employee1("ww", 63, 2341, '男'));
        list.add(new Employee1("ls", 12, 111101, '女'));
        return list;
    }




}
class Employee1 implements Comparable<Employee1>{
    private String name;
    private int age;
    private double salary;
    private char sex;
    @Override
    public int compareTo(Employee1 o) {
        return Integer.compare(this.age, o.age);
    }


    public Employee1(String name, int age, double salary, char sex) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", sex=" + sex +
                '}';
    }

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
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}