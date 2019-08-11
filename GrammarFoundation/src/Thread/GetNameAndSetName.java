package Thread;

import org.junit.Test;

/*
@author 黄佳豪
@create 2019-07-28-11:00
*/
public class GetNameAndSetName {
    @Test
    public void test1() {
        A1 a1 = new A1("zs");
        A1 a2 = new A1("ls");
        A1 a3 = new A1("ww");

        a1.start();a2.start();a3.start();
    }
}

class A1 extends Thread {
    public A1(String name) {
        this.setName(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"----"+i);
        }
    }
}

class B1 extends Thread {

}