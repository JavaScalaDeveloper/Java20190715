package Thread.Case;

/**
 * 多线程模拟售票，多个窗口售票
 * @author ma
 *
 */
public class SellTicktDemoTest {

    public static void main(String[] args) {

        //得到对象
        SellTicktDemo std = new SellTicktDemo();

        //把对象放入线程中
        Thread t1 = new Thread(std,"售票窗口1");
        Thread t2 = new Thread(std,"售票窗口2");
        Thread t3 = new Thread(std,"售票窗口3");
        Thread t4 = new Thread(std,"售票窗口4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }

}
class SellTicktDemo implements  Runnable {


    /*
     * 需求：多线程模拟售票，多个窗口售票
     *
     * 分析：
     *  A.需要的类
     *      1.建立一个多线程的类SellTicktDemo
     *      2.创建一个测试类SellTicktDemoTest
     *  B.类的关系
     *      1.多线程的类SellTicktDemo，实现Runnable接口，重写run()方法
     *      2.SellTicktDemoTest 测试多线程类
     *  C.实现多线程同步
     *      1.用synchronized()方法实现线程同步
     *  D.在SellTicktDemoTest中实现多数窗口
     *
     */

    //定义票的总数
    private int total = 100;

    //定义票的编号
    private int no = total+1;

    //定义一个线程同步对象
    private Object obj = new Object();

    @Override
    public void run() {

        while(true){
            //同步锁
            synchronized(this.obj){
                if(this.total > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String msg = Thread.currentThread().getName()+" 售出第   "+(this.no -this.total) +"  张票";
                    System.out.println(msg);
                    this.total--;
                }else{
                    System.out.println("票已售完，请下次再来！");
                    System.exit(0);
                }
            }
        }

    }
}