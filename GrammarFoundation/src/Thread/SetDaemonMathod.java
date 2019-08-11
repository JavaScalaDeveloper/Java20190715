package Thread;

/*setDaemon(true)
@author 黄佳豪
@create 2019-07-28-16:26
*/
public class SetDaemonMathod {
    public static void main(String[] args) {
        DaemonDemo dd = new DaemonDemo();
        dd.setDaemon(true);
        dd.start();
        for (int i = 0; i <=100; i++) {
            System.out.println("王宝强在拍戏..." + i);


        }
    }
}

class DaemonDemo extends Thread {
    @Override
    public void run() {
        while (true)
            System.out.println("宋喆和马蓉在聊天...");

    }
}