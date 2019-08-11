package Object.Abstract;

import java.net.CacheRequest;

/*
@author 黄佳豪
@create 2019-07-20-18:15
*/
public class AnimalDemo {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.eat();

    }
}

abstract class Animal {
    public Animal() {
        System.out.println("animal");
    }

    void eat() {
        System.out.println("animal should eat...");
    }
}

class Cat extends Animal {
    @Override
    void eat() {
        System.out.println("Cat eat fish...");
    }
}