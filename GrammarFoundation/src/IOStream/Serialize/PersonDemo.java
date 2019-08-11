package IOStream.Serialize;

import org.junit.Test;

import java.io.*;

/*
@author 黄佳豪
@create 2019-07-27-9:42
*/
public class PersonDemo {
    public static void main(String[] args) throws IOException {
        Person p1 = new Person("zs", 10, 120);
        Person p2 = new Person("ls", 12, 100);
        Person p3 = new Person("ww", 54, 160);
        //创建序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("GrammarFoundation\\\\src\\\\IOStream\\\\File\\file5.txt"));
        //序列化对象
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.writeObject(p3);
        oos.close();
    }

    @Test
    @SuppressWarnings("all")
    public void test1() throws IOException {
        Person p1 = new Person("zs", 10, 120);
        Person p2 = new Person("ls", 12, 100);
        Person p3 = new Person("ww", 54, 160);
        //创建序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("GrammarFoundation\\\\src\\\\IOStream\\\\File\\file5.txt"));
        //序列化对象
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.writeObject(p3);
        oos.close();
    }

    @Test//反序列化
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream("D:\\Workspaces\\Java20190715\\GrammarFoundation\\src\\IOStream\\File\\file5.txt"));
        Object o = oos.readObject();
        System.out.println(o);
    }
}

class Person implements Serializable {
private static final Long serializableUID=-1231456474213544l;
    private String name;
    private int age;
    private double weight;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    public Person(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}