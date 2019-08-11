package Object.ObjectArray;

import org.junit.Test;

/*
@author 黄佳豪
@create 2019-07-19-11:13
*/
public class TeacherDemo {
    @Test
    public void test() {
        Teacher t = new Teacher();
        t.setName("zs ");
        Computer c = new Computer();
        c.setBrand(" hasens ");
        c.setPrice(10000);
        t.setComputer(c);
        t.show();
        System.out.println("____________");
        Computer c2 = new Computer("hs",1231234);
        Teacher t2 = new Teacher("ls",c2);
t2.show();
    }
}

class Teacher {
    private String name;
    private Computer computer;

    public Teacher() {
    }



    public Teacher(String name, Computer computer) {
        this.name = name;
        this.computer = computer;
    }

    public void show() {
        System.out.println(name+computer.getBrand()+computer.getPrice());
    }
    public String getInfo() {
        return name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}

class Computer {
    private String brand;
    private double price;

    public Computer() {
    }

    public Computer(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
