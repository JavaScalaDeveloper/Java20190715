package Thread.Case;



/*
@author 黄佳豪
@create 2019-07-28-17:27
*/
public class TicketDemo {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        Thread t1 = new Thread(t,"窗口1");
        Thread t2 = new Thread(t,"窗口2");
        Thread t3 = new Thread(t,"窗口3");
        t1.start();t2.start();t3.start();
    }

}

class Ticket implements Runnable {
    static int ticket = 100;

    @Override
    public void run() {
        synchronized (Ticket.class) {
            while (true) {
               /* try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                if (ticket == 0) {
                    System.out.println("售完");
                    break;
                }

                System.out.println(Thread.currentThread().getName() + "售出第：" + (ticket--));
                /*try {
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }*/
            }
//            this.notifyAll();
        }

    }
}