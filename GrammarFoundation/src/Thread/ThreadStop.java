package Thread;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.Scanner;

/*
@author 黄佳豪
@create 2019-07-28-10:37
通知线程停止
*/
public class ThreadStop {
    public static void main(String[] args) {
        MyThread1 m1 = new MyThread1();
        MyThread2 m2 = new MyThread2(m1);
        m1.start();
        m2.start();
    }
    @Test
    public void test1() {
        StopThread s = new StopThread();
        s.start();
    }

    @Test
    public void test2() {
        MyThread1 m1 = new MyThread1();
        MyThread2 m2 = new MyThread2(m1);
        m1.start();
        m2.start();
    }
}

class StopThread extends Thread {
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            for (int i = 100; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + "死循环" + i);
                if (i == 5) {
                    setFlag(false);
                    System.out.println("shutdown");
                    break;
                }

            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class MyThread1 extends Thread {
    @Override//随机打印100以内的整数
    public void run() {
        while (flag) {
            int num = (int) (Math.random() * 100);
            System.out.println(Thread.currentThread().getName() + "随机数：" + num);
        }
    }

    boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class MyThread2 extends Thread {
    Scanner input = new Scanner(System.in);
    MyThread1 m;

    public MyThread2(MyThread1 m) {
        this.m = m;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("insert:");
            char key = input.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                break;
            }
        }
    }
}