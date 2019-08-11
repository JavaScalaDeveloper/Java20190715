package DataType;

import org.junit.Test;

import java.util.Scanner;

/*
@author 黄佳豪
@create 2019-07-17-9:49
*/
public class ScannerDemo {
    public static void main(String[] args) {
       /* System.out.print("请输入一个整数：");
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        System.out.println("键盘输入的整数位为："+i);*/
        Scanner input = new Scanner(System.in);
        double[][] scores = new double[2][5];
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.println("请输入第"+(j+1)+"名学生的成绩：");
                scores[i][j] = input.nextDouble();



            }

        }
        for (int i = 0; i < scores[i].length-1; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.println(scores[i][j]+"\t");

            }
            System.out.println();
        }
    }

    @Test
    public void test1() {
        /*
        定义变量保存 秒数，打印输出 xx小时xx分钟xx秒
         */
        int H,M,S;//定义小时、分、秒
        long currentTimeMillis = System.currentTimeMillis();
        H=(int)((currentTimeMillis-49*365*24*60*60*1000)/365/24);
        System.out.println(H);
        System.out.println(3 << 3);//3*2^3
    }

    @Test
    public void test3() {
        int I=1;
        int l=2;
        System.out.println("I="+I+"\tl="+l);
        int[] arr = {1, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        Scanner input = new Scanner(System.in);
        double[][] scores = new double[10][5];
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                scores[i][j] = input.nextDouble();

                System.out.println(scores);

            }

        }
    }
}
