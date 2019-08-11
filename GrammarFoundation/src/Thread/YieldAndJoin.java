package Thread;

import javax.swing.border.EmptyBorder;

/*
@author 黄佳豪
@create 2019-07-28-12:56
yield:线程礼让
join：线程插队
*/
public class YieldAndJoin {
    public static void main(String[] args) throws InterruptedException {
        YieldDemo yd = new YieldDemo();
        yd.start();//209__210
        JoinDemo jd = new JoinDemo();
        jd.start();//187_189
        for (int i = 0; i < 5000; i++) {
            if (i >= 5) {
                jd.join();
            }



        }
    }
}

class YieldDemo extends Thread {

    @Override
    public void run() {
        long start=System.currentTimeMillis();
        String str="";
        for (int i = 0; i <=5000; i++) {
            str+="hello"+i;
Thread.yield();
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}

class JoinDemo extends Thread {
    @Override
    public void run() {
        long start=System.currentTimeMillis();
        for (int i = 0; i <=5000; i++) {
//            System.out.println(i);

        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}