package Thread.Case;


/*
@author 黄佳豪
@create 2019-07-28-18:42
*/
public class SingleDemo {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        a1.start();a2.start();a3.start();
    }
}

class A extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(SingleTest.getInstance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class SingleTest {
    //构造器私有化

    public SingleTest() {
    }
    //创建内部Single的引用
    private static SingleTest singleTest;

    //提供一个公共方法对外暴露该对象
    public static SingleTest getInstance() throws InterruptedException {
        synchronized (SingleTest.class) {
            if (singleTest == null) {
                Thread.sleep(10);
                singleTest = new SingleTest();
            }
            return singleTest;
        }
    }
}
