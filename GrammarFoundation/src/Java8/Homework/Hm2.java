package Java8.Homework;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*定义好Employee类，包含姓名、年龄、工资、性别属性，并封装
定义一个List类，添加多个员工

问题：针对定义好的员工的集合数据，有如下的一些需求，我们考虑如何完成？
需求1：获取当前公司中员工年龄大于30的员工信息
需求2：获取公司中工资大于 5000 的员工信息
需求3：获取性别为男的员工信息

提示：是否可以使用Lambda表达式

@author 黄佳豪
@create 2019-07-31-10:41
*/
public class Hm2 {
    List<Employee> list;

    public static void main(String[] args) {


    }

    @Before
    public void before() {
        list = EmployeeData.getEmployees();
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void test1() {
        List<Employee> employeeByAge = getEmployeeByAge(list);
        for (Employee employee : employeeByAge) {
            System.out.println(employee);
        }
    }

    @Test
    public void test2() {
        filterEmployees(list, t -> t.getAge() > 30);
    }

    @Test
    public void test() {

    }

    //获取公司年龄大于30的员工
    public List<Employee> getEmployeeByAge(List<Employee> list) {
        List<Employee> datas = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() > 30) {
                datas.add(employee);
            }
        }
        return datas;
    }

    //获取工资大于10000的员工
    public List<Employee> getEmployeeBySalary(List<Employee> list) {
        List<Employee> datas = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getSalary() > 10000) {
                datas.add(employee);
            }
        }
        return datas;
    }

    //获取性别为男的员工
    public List<Employee> getEmployeeBySex(List<Employee> list) {
        List<Employee> datas = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getSex() == '男') {
                datas.add(employee);
            }
        }
        return datas;
    }

    //进阶2
    public List<Employee> filterEmployees(List<Employee> list, MyPredicate<Employee> p) {
        List<Employee> datas = new ArrayList<>();
        for (Employee employee : list) {
            if (p.test(employee)) {
                datas.add(employee);
            }

        }
        return datas;
    }

}

interface MyPredicate<T> {
    boolean test(T t);
}

class Employee {
    private String name;
    private int age;
    private double salary;
    private char sex;

    public Employee(String name, int age, double salary, char sex) {
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

//员工信息类
class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("zs", 18, 11111, '男'));
        list.add(new Employee("wq", 43, 2234, '男'));
        list.add(new Employee("zl", 24, 5431, '男'));
        list.add(new Employee("ww", 63, 2341, '男'));
        list.add(new Employee("ls", 12, 111101, '女'));
        return list;
    }
}