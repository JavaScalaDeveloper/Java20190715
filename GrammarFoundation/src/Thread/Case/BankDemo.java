package Thread.Case;

import org.omg.CORBA.OMGVMCID;

/*
模拟银行取钱的问题
1.定义一个Account类
1）该Account类封装了账户编号（String）和余额（double）两个属性
2）设置相应属性的getter和setter方法
3）提供无参和有两个参数的构造器
4）系统根据账号判断与用户是否匹配，需提供hashCode()和equals()方法的重写
2.提供一个取钱的线程类
1）提供了Account类的account属性和double类的取款额的属性
2）提供带线程名的构造方法
3）run()方法中提供取钱的操作
3.在主类中创建线程进行测试。考虑线程安全问题。


@author 黄佳豪
@create 2019-07-29-10:46
*/
public class BankDemo {
    public static void main(String[] args) {
        Account ac = new Account("zs", 100000);
        Deposit d = new Deposit(ac);
        d.start();
        WithDraw w = new WithDraw(ac);
        w.start();
    }
}

class WithDraw extends Thread {
    Account acc;

    public WithDraw(Account acc) {
        this.acc=acc;
    }

    @Override
    public synchronized void run() {
        while (true) {
            int money = (int) (Math.random() * 1001);
            while (money >= acc.getMoney()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            acc.setMoney(acc.getMoney()-money);
            System.out.println(Thread.currentThread().getName()+"取了￥"+money+",账户余额：￥"+acc.getMoney());
            this.notifyAll();
        }
    }
}
//存钱
class Deposit extends Thread {
    Account acc;

    public Deposit(Account acc) {
        this.acc=acc;
    }

    @Override
    public synchronized void run() {
        while (true) {
            while (acc.getMoney() > 100000) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int money = (int) (Math.random() * 1001);
            acc.setMoney(acc.getMoney()+money);
            System.out.println(Thread.currentThread().getName()+"存了￥"+money+",账户余额：￥"+acc.getMoney());
            this.notifyAll();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Account {
    private String accNo;
    private double money;

    @Override
    public String toString() {
        return "Account{" +
                "accNo='" + accNo + '\'' +
                ", money=￥" + money +
                '}';
    }

    public Account() {
    }

    public Account(String accNo, double money) {
        this.accNo = accNo;
        this.money = money;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}