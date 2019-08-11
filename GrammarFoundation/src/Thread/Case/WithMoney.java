package Thread.Case;

/*不动
@author 黄佳豪
@create 2019-07-28-18:19
*/
public class WithMoney {
    public static void main(String[] args) {
        WithDrawMoney w = new WithDrawMoney();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }
}

class WithDrawMoney implements Runnable {
   static int money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                if (money <= 0) {
                    System.out.println("取完");
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "取了1000，余额为：" + (money -= 1000));
                //通知对方线程可以取钱
                notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}