package Thread.Homework;

import java.util.ArrayList;
import java.util.List;

/*半成品
编写程序，在main方法中创建一个线程。线程每隔一定时间（200ms以内的随机时间）产生一个0-100之间的随机整数，打印后将该整数放到集合中；
共产生100个整数，全部产生后，睡眠30秒，然后将集合内容打印输出；
在main线程中，唤醒interrupt上述睡眠的线程，使其尽快打印集合内容。
@author 黄佳豪
@create 2019-07-28-22:00
*/
public class Hw4 {
    public static void main(String[] args) {
        PrinterDemo2 p = new PrinterDemo2();
        p.start();

    }
}

class PrinterDemo2 extends Thread {
    List list = new ArrayList();
    int i = 0;

    @Override
    public void run() {
        synchronized (this) {
            while (i <= 100) {
                int j = (int) (Math.random() * 100);
                System.out.println(j);
                list.add(j);
                i++;
            }
            notify();
            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Object o : list) {
                System.out.print(o + "\t");
            }
        }
    }
}