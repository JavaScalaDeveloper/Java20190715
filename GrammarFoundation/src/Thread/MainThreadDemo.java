package Thread;

import java.util.concurrent.Callable;

/*
@author 黄佳豪
@create 2019-07-27-16:32
*/
public class MainThreadDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getName());
        MyThread m = new MyThread();
        m.call();//实现collable有返回值
    }
}

class MyThread implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("-----Mythread");
        return 200;
    }
}