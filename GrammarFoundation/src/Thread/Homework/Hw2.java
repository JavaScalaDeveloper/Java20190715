package Thread.Homework;

/*半成品
2:模拟一个人生产50个玩具，每200毫秒生产一个，当生产到第20个时加入每秒吃1个馒头，共吃完3个后在接着生产的多线程。
@author 黄佳豪
@create 2019-07-28-21:34
*/
public class Hw2 {
    public static void main(String[] args) {
        Worker w = new Worker();
        w.start();
    }
}

class Worker extends Thread {
    int num = 1;
    Eeater e = new Eeater(true);

    @Override
    public void run() {
        while (true) {
            synchronized (Worker.class) {

                if (num > 50) {
                    System.out.println("shutdown");
                    break;
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (num == 20) {
                    synchronized (this) {
                        e.start();
                        try {
                            wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        notifyAll();
                    }

                }

                System.out.println("正在生产第" + (num++) + "个玩具");
            }
        }
    }
}


class Eeater extends Thread {
    int num = 1;
    boolean isflag = true;

    public Eeater(boolean isflag) {
        this.isflag = isflag;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (isflag) {
                if (num > 3) {
                    System.out.println("shutdown");
                    isflag=false;
//                    break;
                    notifyAll();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("正在吃第" + num++ + "个馒头");
            }
        }
    }
}