package Thread;

import java.sql.SQLOutput;

/*
@author 黄佳豪
@create 2019-07-28-19:04
绑匪绑了李员外的千金
*/
public class DeadLockDemo {
    public static void main(String[] args) {
        DeadDemo d1 = new DeadDemo(true);
        DeadDemo d2 = new DeadDemo(false);
        d1.start();
        d2.start();
    }
}

class DeadDemo extends Thread {
    MrLi ml = new MrLi();
    BadBoy bb = new BadBoy();
    private boolean flag;

    public DeadDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {//MrLi
            synchronized (bb) {
                ml.say();
                synchronized (ml) {
                    ml.get();
                }
            }
        } else {//Bad
            synchronized (ml) {
                ml.say();
                synchronized (bb) {
                    ml.get();
                }
            }
        }
    }
}

class BadBoy {
    public void say() {
        System.out.println("Bad:get money");
    }

    public void get() {
        System.out.println("have money");
    }
}

class MrLi {
    public void say() {
        System.out.println("MrLI：你先给人");
    }

    public void get() {
        System.out.println("成功救出");
    }
}
