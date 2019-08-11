package cn.hjhstudy.Customer;

import java.util.*;

public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * 功能：返回一个有效的字符，值：1——5
     * @return char
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);//一个有效字符
            c = str.charAt(0);//将String类型转换成char类型
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }
    /**
     * 功能：用于返回任意单个字符
     * @return 单个字符
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

//    public static void main(String[] args) {
//		char ch = readChar('中');
//		System.out.println(ch);
//	}


    /**
     * 功能：如果直接敲回车，返回默认值；如果输入有效字符，则返回字符
     * @param defaultValue
     * @return
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);//如果敲回车，则直接返回""; 如果不敲回车，则返回一个新字符
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }


    /**
     * 功能：返回键盘输入的任意整型
     * @return
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 功能：如果敲回车，则返回默认值；如果没有敲回车，则返回输入的整型
     * @param defaultValue
     * @return
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    /**
     * 功能：返回不超过指定长度的有效字符串
     * @param limit
     * @return
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }
    /**
     * 功能：如果直接敲回车，则返回默认值；如果没有敲回车，则返回输入的有效字符串
     * @param limit
     * @param defaultValue
     * @return
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }
    /**
     * 功能：返回确认选项，要么是Y，要么是N
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }


    /**
     * 功能：用于接受不超过指定的长度的字符串
     * @param limit 最大长度
     * @param blankReturn 标记
     * @return 有效的字符串
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {//limit:1  ,blankReturn:true
        String line = "";

        while (scanner.hasNextLine()) {
            /*
             * //nextLine和next很像，都是用于接受键盘输入的字符串
             * next:遇到\n或\t或空格结束，只能接受这些字符前面的有效字符，示例：输入 12345 6789，接收到的是：12345
             * nextLine:遇到\n结束，认为\t或空格为有效字符，可以接受\n之前的所有字符，示例：输入：12345 6789，接受到的是：12345 6789
             */
            line = scanner.nextLine();//""    abc
            if (line.length() == 0) {//相当于敲入回车
                if (blankReturn) return line;//""
                else continue;//不要空字符串，希望可以继续循环实现键盘输入，直到输入有效字符为止
            }

            if (line.length() < 1 || line.length() > limit) {//判断输入的字符，是否超过指定的长度
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
}
