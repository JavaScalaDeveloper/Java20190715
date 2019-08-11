package Object.Abstract;


/*
@author 黄佳豪
@create 2019-07-21-17:46
有一个交通工具接口类Vehicles，有work接口，有Horse类和Boat类分别实现Vehicles，创建交通工具工厂类，
有两个方法分别获得交通工具Horse和Boat；有Person类，有name和Vehicles属性，在构造器中为两个属性赋值，
实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具。
*/
public class InterfaceHomework2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();{
            Vehicles v;
            String weather = "1";//不接受用户输入，假设遇到了河
            if (weather == "1") {
                v = VehiclesFoctory.getBoat();
            } else {
                v = VehiclesFoctory.getHorse();
            }
            Person2 p = new Person2("唐僧", v);
            System.out.print(p.name + " by ");
            p.drive();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时="+(end-start));
    }
}

class Person2 {
    String name;
    Vehicles vehicles;

    public Person2(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void drive() {
        Vehicles w = vehicles.work();
        w.work();
    }

}

class VehiclesFoctory {
    public static Vehicles getHorse() {
       return new Horse();
    }

    public static Vehicles getBoat() {
        return new Boat();
    }
}

interface Vehicles {
    Vehicles work();
}

class Horse implements Vehicles {
    public Horse() {
        System.out.println("Horse");
    }

    @Override
    public Vehicles work() {
        return Horse::new;
    }
}

class Boat implements Vehicles {

    @Override
    public Vehicles work() {
        System.out.println("Boat");
        return Boat::new;
    }
}