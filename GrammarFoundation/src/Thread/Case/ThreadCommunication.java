package Thread.Case;

import org.omg.PortableInterceptor.INACTIVE;

/*线程通信
@author 黄佳豪
@create 2019-07-29-10:04
*/
public class ThreadCommunication {
    public static void main(String[] args) {
        Clerk c = new Clerk();
        Productor p = new Productor(c);
        p.start();
        Consumer con = new Consumer(c);
        con.start();
    }
}

class Consumer extends Thread {
    private Clerk c;

    public Consumer(Clerk c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            //消费商品
//            Clerk c = new Clerk();
            try {
                c.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor extends Thread {
    private Clerk c;

    public Productor(Clerk c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            //生产产品，调用Clerk的save
//            Clerk c = new Clerk();
            try {
                c.save();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Clerk {
    int count = 0;

    //保存商品
    public synchronized void save() throws InterruptedException {
        if (count >= 20) {
            this.wait();
        }
        Thread.sleep(100);
        System.out.println("生产者生产一件商品，库存为：" + (++count));
        this.notify();//唤醒消费者线程
    }

    //消费
    public synchronized void get() throws InterruptedException {
        if (count <= 0) {
            this.wait();
        }
        Thread.sleep(100);
        System.out.println("消费者正在消费一件商品，库存为：" + (--count));
        this.notify();
    }
}