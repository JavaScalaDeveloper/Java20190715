package Object.Abstract;

/*
@author 黄佳豪
@create 2019-07-20-18:32
*/
public class EmployeeDemo {
    public static void main(String[] args) {
       Manager m= new Manager("zs",12,123124);
        m.work();
        m.toString();
        Employee e=new Manager("x",12,43);
    }
}

abstract class Employee {
    private String name;
    private int age;
    private double salary;

    public abstract void work();
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

class Manager extends Employee {

    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }

    public Manager() {
        super();
    }

    @Override
    public void work() {
        System.out.println("员工的工作");
    }

    @Override
    public String toString() {
        return getName()+getAge()+getSalary();
    }
}