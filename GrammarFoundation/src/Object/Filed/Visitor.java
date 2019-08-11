package Object.Filed;

import java.util.Scanner;

/*一个景区根据游人的年龄收取不同价格的门票。请编写游人类，根据年龄段决定能够购买的门票价格并输出
门票：18-60：20，其他：1元
@author 黄佳豪
@create 2019-07-18-12:26
*/
public class Visitor {

    public static void main(String[] args) {
        String name;
        int age;
        int tickets;//单人门票费
        int numPerson;//人数
        int numTickets=0;//门票总费
        Scanner input = new Scanner(System.in);
        System.out.print("请输入游客人数：");

        numPerson = input.nextInt();//此处需要判断输入是否合法
//判断年龄
        for (int i = 0; i <numPerson; i++) {
            System.out.print("请输入第" + (i + 1) + "位游客姓名：");
            name = input.next();
            System.out.print("请输入游客" +name+ "的年龄：");
            age = input.nextInt();
            if (age > 0 && age < 120) {
                if (age >= 18 && age < 60) {
                    tickets = 20;
                    numTickets+=20;
                } else {
                    tickets = 1;
                    numTickets+=1;
                }
                System.out.println("游客" + name + "的门票为：￥"+tickets+"元");
            } else {
                System.out.println("输入错误，请重新输入！");
                i--;
            }
        }
        System.out.println(numPerson+"位游客门票总费用为：￥"+numTickets+"元");
    }
}
