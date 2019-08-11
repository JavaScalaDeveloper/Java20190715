package DataType;

import java.util.Scanner;

/*
@author 黄佳豪
@create 2019-07-18-7:48
*/
public class MyFamilyAccount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String details = "收支\t收支金额\t账户金额\t说     明";
        int money = 0;
        boolean loop = true;
        do {
            System.out.println("\n-------------家庭收支记账软件--------------");
            System.out.println("                 1 收支明细                     ");
            System.out.println("                 2 登记收入                     ");
            System.out.println("                 3 登记支出                     ");
            System.out.println("                 4 退出\n                     ");
            System.out.print("                 请输入1-4：");
            char key = input.next().charAt(0);
                      switch (key) {
                case '1':
                    System.out.println("------------收支明细----------");
                    System.out.println(details);
                    if (money == 0) {
                        System.out.println("赶紧存入一笔钱吧！");
                    }
                    break;
                case '2'://收支金额、说明
                    System.out.print("收入金额：");
                    int balance = input.nextInt();//此处可以判断输入类型是否为int型
                    System.out.print("收入说明：");
                    String account = input.next();
                    money += balance;
//                    details += "\n收入\t" + balance + "\t" + "\t"+ "\t" + money + "\t" + "\t"+ "\t" + account ;
                    details += String.format("\n收入\t%d\t%d\t%s", balance, money, account);
                    break;
                case '3':
                    System.out.print("支出金额：");
                    int balance2 = input.nextInt();
                    System.out.print("支出说明：");
                    String account2 = input.next();
                    money -= balance2;
                    details += "\n支出\t" + balance2 + "\t" + "\t" + "\t" + money + "\t" + "\t" + "\t" + account2;
                    System.out.println("登记完成！");
                    break;
                case '4':
                    System.out.print("确定退出？y/n:");
                    boolean isFlag = true;
                    while (isFlag){
                        char confirm = input.next().toUpperCase().charAt(0);
                       switch (confirm) {
                            case 'Y':
                                System.out.println("程序退出！");
                                return;
                            case 'N':
                                isFlag = false;
                                System.out.println("----返回收支软件！-----");
                                break ;
                            default:
                                System.out.print("请重新输入（y/n）:");
                        }

                    }
                    break;
                          default:
                              throw new IllegalStateException("Unexpected value: " + key);
                      }
        } while (loop);
    }
}
