package Thread;

import org.junit.Test;

import java.util.PriorityQueue;

/*线程优先级
@author 黄佳豪
@create 2019-07-28-12:37
*/
public class ThreadPrecedenceDemo {
    public static void main(String[] args) {
        PriorityDemo p1 = new PriorityDemo();
        PriorityDemo p2 = new PriorityDemo();
        PriorityDemo p3 = new PriorityDemo();
        p1.setPriority(Thread.MAX_PRIORITY);
        p3.setPriority(Thread.MIN_PRIORITY);
        p2.setPriority(Thread.NORM_PRIORITY);
        p1.start();
        p2.start();
        p3.start();
    }

    @Test
    public void test() {
        PriorityDemo1 p1 = new PriorityDemo1();
        PriorityDemo1 p2 = new PriorityDemo1();
        PriorityDemo1 p3 = new PriorityDemo1();
        p1.setPriority(Thread.MAX_PRIORITY);
        p3.setPriority(Thread.MIN_PRIORITY);
        p2.setPriority(Thread.NORM_PRIORITY);
        p1.start();
        p2.start();
        p3.start();
    }
}

class PriorityDemo extends Thread {
    static int ii = 100;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = ii; i > 0;i-- ) {
                System.out.println(Thread.currentThread() + "-----" + i);
            }

        }
    }
}

class PriorityDemo1 extends Thread {
    static int ii = 100;

    @Override
    public void run() {
        synchronized (this) {
            while (ii >= 0) {
                System.out.println(Thread.currentThread()+ "-----" + ii--);
            }

        }
    }
}