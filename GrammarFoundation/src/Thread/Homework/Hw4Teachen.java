package Thread.Homework;

import java.util.ArrayList;

/*
@author 黄佳豪
@create 2019-07-29-11:24
*/
public class Hw4Teachen {
    public static void main(String[] args) throws InterruptedException {
        PrintNum p=new PrintNum();
        p.start();
/*        Thread.sleep(1000);
        p.interrupt();*/
    }
}

class PrintNum extends Thread {
    @Override
    public void run() {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            try {
                Thread.sleep((int)(Math.random()*200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int num = (int) (Math.random() * 101);
            list.add(num);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印集合
        for (Object o : list) {
            System.out.print(o+"\t");

        }
    }
}