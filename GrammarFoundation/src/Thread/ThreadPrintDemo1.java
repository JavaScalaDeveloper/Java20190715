package Thread;

import org.junit.Test;

/*
@author 黄佳豪
@create 2019-07-28-10:09
创建两个子线程，让其中一个输出1-100之间的偶数，另一个输出1-100之间的奇数。

*/
public class ThreadPrintDemo1 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.start();
        b.start();

    }

    @Test
    public void ticket() {
        SellTiket s1 = new SellTiket();
        SellTiket s2 = new SellTiket();
        SellTiket s3 = new SellTiket();
        s1.start();
        s2.start();
        s3.start();
    }
}

class A extends Thread {
    public void run() {
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(1);//休眠
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 2 == 0) {
                System.out.println("A-------" + i);
            }

        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 2 != 0) {
                System.out.println("B--" + i);
            }

        }
    }
}

class SellTiket extends Thread {
    static int ticket = 100;

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                if (ticket <= 0) {
                    System.out.println(Thread.currentThread().getName() + "售完");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "卖出一票，余票为：" + (--ticket));

            }

        }
    }
}