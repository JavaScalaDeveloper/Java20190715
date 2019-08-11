package Object.StaticAndFinal;

import javax.activation.MailcapCommandMap;

/*
@author 黄佳豪
@create 2019-07-20-11:57
*/
public class AccountDemo {
    public static void main(String[] args) {
        Account a1 = new Account("12345",234432);
        Account a2 = new Account("123456",2424);
        Account a3 = new Account("12345354",5334432);
        Account a4 = new Account("12345654",3245622);
        Account a5 = new Account("1234245",65334);

        System.out.println(a1.toString()+a2.toString()+a3.toString()+a4.toString()+a5.toString());
    }
}

class Account {
    private int accountNo;
    private String pwd;
    private double money;
    private static double rate=0.001;
    private static double miniBanlance=10;

    @Override
    public String toString() {
        return "Account{" +
                "accountNo='" + accountNo + '\'' +
                ", pwd='" + pwd + '\'' +
                ", money=" + money +
                '}'+"\n";
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo++;
    }



    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public static double getRate() {
        return rate;
    }

    public static void setRate(double rate) {
        Account.rate = rate;
    }

    public static double getMiniBanlance() {
        return miniBanlance;
    }

    public static void setMiniBanlance(double miniBanlance) {
        Account.miniBanlance = miniBanlance;
    }

    public Account(String pwd, double money) {
        this.pwd = pwd;
        this.money = money;
//        this.accountNo=this.getAccountNo()+1;
        this.accountNo++;
    }

    public Account(int accountNo, String pwd, double money) {
        this(pwd, money);
        this.accountNo = accountNo;

    }

    public Account() {
    }
}