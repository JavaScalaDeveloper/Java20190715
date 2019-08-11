package DataType;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/*一、已知有个排序好（升序）的数组，要求插入一个元素，最后打印该数组，顺序依然是升序
二：定义一个3行4列的二维数组，逐个从键盘输入值，编写程序将四周的数据清0

三、定义一个4行4列的二维数组，逐个从键盘输入值，然后将第1行和第4行的数据进行交换，将第2行和第3行的数据进行交换

@author 黄佳豪
@create 2019-07-18-10:13
*/
public class ArrayHomework {
    @Test
    public static void main(String[] args) {

        {
//            一、已知有个排序好（升序）的数组，要求插入一个元素，最后打印该数组，顺序依然是升序
            System.out.println("------------作业一-------------");
            Scanner input = new Scanner(System.in);
            int[] arr = {
                    1, 3, 4, 5, 7
            };
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
            System.out.print("请输入要插入对元素：");
            //扩容
            int add = Integer.parseInt(input.next());
            //查找要插入索引的位置
            int[] newArr = Arrays.copyOf(arr, arr.length + 1);
            int index = newArr.length - 1;//默认索引在最后一个位置
            for (int i = 0; i < arr.length; i++) {
                if (add < arr[i]) {
                    index = i;
                    break;
                }

            }
            //循环后移
            for (int i = newArr.length - 1; i > index; i--) {
                newArr[i] = newArr[i - 1];
            }
            newArr[index] = add;
            arr = newArr;
            System.out.println("插入成功！");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
            System.out.println();
        }
    }
}