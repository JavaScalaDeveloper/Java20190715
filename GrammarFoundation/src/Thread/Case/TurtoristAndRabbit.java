package Thread.Case;

/*
@author 黄佳豪
@create 2019-07-28-16:46
*/
public class TurtoristAndRabbit {
    public static void main(String[] args) {
        Torist t = new Torist();
        Rabbit r = new Rabbit();
        r.setName("兔子 ");
        t.setName("乌龟 ");
        t.start();r.start();
    }
}
@SuppressWarnings("all")//忽略重复代码警告
class Torist extends Thread {
    @Override
    public void run() {
        long start=System.currentTimeMillis();
        for (int i = 0; i <30; i++) {
            try {
                Thread.sleep(1000);//龟速1米每秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "m");
            if (i>0&&i%10==0) {
                try {
                    Thread.sleep(1000);
                    System.out.println(getName()+"休息一秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("乌龟在第"+(end-start)/1000+"秒到达终点。");
    }
}
@SuppressWarnings("all")
class Rabbit extends Thread {
    @Override
    public void run() {
        long start=System.currentTimeMillis();

        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(100);//兔速1米每秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "m");
            if (i>0&&i%10==0) {
                try {
                    Thread.sleep(1000);
                    System.out.println(getName()+"休息一秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("兔子在第"+(end-start)/1000+"秒到达终点。");
    }
}