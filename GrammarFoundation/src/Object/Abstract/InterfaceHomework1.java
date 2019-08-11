package Object.Abstract;

import org.junit.runner.Computer;

/*
@author 黄佳豪
@create 2019-07-21-17:35
多态参数：有一个显示器接口Graphoscope，具有display方法，有两个类：
台式显示器和液晶显示器都实现显示器接口，有Computer类，有个测试显示器testGraphoscope的方法，
要求传入显示器接口对象，测试显示功能，生产两台电脑，分别配置台式显示器和液晶显示器。查看是否正常运行
*/
public class InterfaceHomework1 {
    public static void main(String[] args) {
        Computer1 c1 = new Computer1();
        Computer1 c2 = new Computer1();
        c1.testGraphoscope(new Desk());
        c2.testGraphoscope(new Liquid());
    }
}

interface Graphoscope {
    void display();
}

class Computer1 {
    public void testGraphoscope(Graphoscope gs) {
        gs.display();
    }
}
class Desk implements Graphoscope{
    @Override
    public void display() {
        System.out.println("我是台式");
    }
}

class Liquid implements Graphoscope{

    @Override
    public void display() {
        System.out.println("我是液晶");
    }
}