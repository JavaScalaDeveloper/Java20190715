package Object.Filed;


import java.util.Scanner;

/*
@author 黄佳豪
@create 2019-07-18-17:18
一、编写一个Dog类，
包含name、age、weight属性类中声明一个say方法，
方法打印信息中包含所有属性值。 在另一个TestDog类中的main方法中
，创建Dog对象，并访问say方法和所有属性，将调用结果打印输出。

二、定义一个圆类型
	定义属性：半径
提供显示圆周长功能的方法
提供显示圆面积的方法

三、小小计算器进阶
*************************************
	    小小计算器
*************************************
请输入第一个整数：10
请输入第二个整数：5
请选择操作（1.加法 2.减法 3.乘法 4.除法 0.退出） ： 1
10 + 5 =15
请选择操作（1.加法 2.减法 3.乘法 4.除法 0.退出） ： 2
10 - 5 =5
请选择操作（1.加法 2.减法 3.乘法 4.除法 0.退出） ： 0
程序退出
四、使用面向对象方式实现：
循环为十名学生的姓名和成绩赋值，最后打印成绩的和 、最大值
*/
public class Homework {
    public static void main(String[] args) {
        System.out.println("-----作业一-----\n-----打印Dog对信息-----\n----------------");
        Homework1 dog = new Homework1();
        dog.say("zhangsan ", 2, 16);
        System.out.println("-----作业二-----\n-----计算圆的周长和面积-----\n----------------");
        Homework2 y = new Homework2();
        y.perimeter(1234.56);//计算圆的周长
        y.area(43.234);//计算圆的面积
        System.out.println("-----作业三-----\n-----计算器-----\n----------------");
        Scanner input = new Scanner(System.in);
        boolean isFlag = true;//定义循环条件
        while (isFlag) {//开始循环
            Homework3 h3 = new Homework3();
            System.out.print("请选择操作（1.加法 2.减法 3.乘法 4.除法 0.退出） ：");
            int ipt = input.nextInt();
            if (ipt == 0) {//截断退出程序
                System.out.println("退出程序...");
                isFlag = false;
            }//判断用户输入数值是否符合要求
            else if (ipt != 1 & ipt != 2 & ipt != 3 & ipt != 4) {
                System.out.println("请输入0-4！");
            } else {
                System.out.print("请输入num1的值：");
                int n1 = input.nextInt();
                System.out.print("请输入num2的值：");
                int n2 = input.nextInt();
                //定义循环条件
                switch (ipt) {
                    case 1://加法
                        h3.add(n1, n2);
                        break;
                    case 2://减法
                        h3.red(n1, n2);
                        break;
                    case 3://乘法
                        h3.mul(n1, n2);
                        break;
                    case 4://除法
                        h3.div(n1, n2);
                        break;
                }
            }
        }
        System.out.println("-----作业四-----\n-----计算10位学生成绩-----\n----------------");
        //循环录入学生成绩
        int[] grade = new int[10];
//依次录入学生成绩
        for (int i = 0; i < grade.length; i++) {
            System.out.print("请输入第" + (i + 1) + "位学生的成绩：");
            grade[i] = input.nextInt();
        }
        Homework4 h4 = new Homework4();
//        打印学生总成绩
        h4.sumGrade(grade);
//        打印成绩最大值
        h4.maxGrade(grade);
    }
}

/*一、编写一个Dog类，
        包含name、age、weight属性类中声明一个say方法，
        方法打印信息中包含所有属性值。 在另一个TestDog类中的main方法中
        ，创建Dog对象，并访问say方法和所有属性，将调用结果打印输出。*/
class Homework1 {
    String name;
    int age, weight;

    //构造带参say方法
    public void say(String name, int age, int weight) {
        System.out.println("The Dog's name:" + name + ",age:" + age + "years old,weight:" + weight + "kg.");
    }
}

/*二、定义一个圆类型
        定义属性：半径
        提供显示圆周长功能的方法
        提供显示圆面积的方法*/
class Homework2 {
    //    double r;//定义半径可以省略
//    计算圆的周长方法
    public double perimeter(double r) {
        double perimeter = 2 * r * Math.PI;
        System.out.println("园的周长为：" + perimeter);
        return perimeter;
    }

    //计算圆的面积方法
    public double area(double r) {
        double area = r * r * Math.PI;
        System.out.println("圆的面积为：" + area);
        return area;
    }

}

/*
三、小小计算器进阶
        *************************************
        小小计算器
        *************************************
        请输入第一个整数：10
        请输入第二个整数：5
        请选择操作（1.加法 2.减法 3.乘法 4.除法 0.退出） ： 1
        10 + 5 =15
        请选择操作（1.加法 2.减法 3.乘法 4.除法 0.退出） ： 2
        10 - 5 =5
        请选择操作（1.加法 2.减法 3.乘法 4.除法 0.退出） ： 0
        程序退出*/
class Homework3 {
    //加法运算
    public double add(int num1, int num2) {//+
        System.out.println("num1 + num2=" + (num1 + num2));
        return num1 + num2;
    }

    //减法运算
    public double red(int num1, int num2) {//-
        System.out.println("num1 - num2=" + (num1 + -num2));
        return num1 + num2;
    }

    //乘法运算
    public double mul(int num1, int num2) {//'*'
        System.out.println("num1 * num2=" + (num1 * num2));
        return num1 * num2;
    }

    //除法运算
    public double div(int num1, int num2) {//'/'
        System.out.println("num1 / num2=" + (num1 / num2));
        return num1 / num2;
    }
/*//关闭程序
    public void shutDown() {

        return;
    }*/
}

/*
        四、使用面向对象方式实现：
        循环为十名学生的姓名和成绩赋值，最后打印成绩的和 、最大值
        */
class Homework4 {
    //构造计算总成绩方法
    public int sumGrade(int[] grage) {//定义数组存入数值
        int sumGrade = 0;
        //依次累加学生成绩
        for (int i = 0; i < grage.length; i++) {
            sumGrade += grage[i];
        }
        System.out.println("成绩总和为：" + sumGrade);
        return sumGrade;
    }

    //构造计算最大值方法
    public int maxGrade(int[] grage) {
        int maxGrade = 0;
        //通过遍历比较数组元素得出最大值
        for (int i = 0; i < grage.length; i++) {
            if (maxGrade < grage[i]) {
                maxGrade = grage[i];
            }
        }
        System.out.println("最大值为：" + maxGrade);
        return maxGrade;
    }
}