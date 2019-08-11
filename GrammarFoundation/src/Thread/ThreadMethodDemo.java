package Thread;

/*
@author 黄佳豪
@create 2019-07-28-12:29
*/
public class ThreadMethodDemo {
    public static void main(String[] args) {
        SleepThread st = new SleepThread();
        st.start();
        for (int i = 0; i <=100; i++) {
            System.out.println("active--"+i);
            if (i == 10) {
                st.interrupt();//中断
            }

        }
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(st.getPriority());
    }
}

class SleepThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            System.out.println(Thread.currentThread().getName()+i);
        }
        System.out.println("stop!");
    }
}