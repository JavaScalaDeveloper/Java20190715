package Thread.Homework;

/*
1.打印1——100，通过两个线程，实现一一交替
@author 黄佳豪
@create 2019-07-28-21:26
*/
public class Hw1 {
    public static void main(String[] args) {
        PrinterDemo p1 = new PrinterDemo();
        PrinterDemo p2 = new PrinterDemo();
        p1.setName("线程一：");
        p2.setName("线程二：");
        p1.start();
        p2.start();
    }
}

class PrinterDemo extends Thread {
    static int i0 = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (PrinterDemo.class) {

                if (i0 <= 0) {
                    System.out.println("shutdown");
                    break;
                }
                System.out.println(getName() + (i0--));
            }
        }
    }

}