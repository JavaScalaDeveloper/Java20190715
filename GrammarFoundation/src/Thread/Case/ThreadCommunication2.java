package Thread.Case;

/*线程通信
多个生产者和多个消费者
修改：
①notify-->notifyAll
②if判断-->wait的判断条件
@author 黄佳豪
@create 2019-07-29-10:04
*/
public class ThreadCommunication2 {
    public static void main(String[] args) {
        Clerk2 c = new Clerk2();
        Productor2 p1 = new Productor2(c);
        Productor2 p2 = new Productor2(c);
        Productor2 p3 = new Productor2(c);
        p1.start();p2.start();p3.start();
        Consumer2 con1 = new Consumer2(c);
        Consumer2 con2 = new Consumer2(c);
        Consumer2 con3 = new Consumer2(c);
        con1.start();con2.start();con3.start();
    }
}

class Consumer2 extends Thread {
    private Clerk2 c;

    public Consumer2(Clerk2 c) {
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

class Productor2 extends Thread {
    private Clerk2 c;

    public Productor2(Clerk2 c) {
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

class Clerk2 {
   static int count = 0;

    //保存商品
    public synchronized void save() throws InterruptedException {
        while (count >= 20) {
            this.wait();
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"生产者生产一件商品，库存为：" + (++count));
        this.notifyAll();//唤醒消费者线程
    }

    //消费
    public synchronized void get() throws InterruptedException {
        while (count <= 0) {
            this.wait();
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"消费者正在消费一件商品，库存为：" + (--count));
        this.notifyAll();
    }
}