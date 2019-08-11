package JavaCoreAPI.MathClass;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/*
@author 黄佳豪
@create 2019-07-23-17:25
4.获取两个字符串中最大相同子串。比如：
   str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
   提示：将短的那个串进行长度依次递减的子串与较长
   的串比较。

5.对字符串中字符进行自然顺序排序。
提示：
1）字符串变成字符数组。
2）对数组排序，选择，冒泡，Arrays.sort();
3）将排序后的数组变成字符串。

6.自己设计一个方法实现，比较两个字符串大小
*/
public class Homework1 {
    @Test
    public void test1() {
        StringUtils s = new StringUtils("sgsdfsde","sgs");
        s.toString();
        StringUtils.getMaxSub("ssanfaag","skanfjsngdksjfgsanajglsakn");
        StringUtils.sortString("12342sfsgnsfg");
    }
}

/*
字符串出现的个数
 */
class StringUtils {


    public StringUtils(String string, String sub) {
        int count = 0;
        int index;
        while ((index=string.indexOf(sub))!=-1) {

            string = string.substring(index + sub.length());
            count++;
        }
//        return count;
        System.out.println(count);
    }

    //返回最大的相同串
    public static void getMaxSub(String s1, String s2) {
        String max=s1.length()>=s2.length()?s1:s2;
        String min=s1.length()<s2.length()?s1:s2;
        for (int i = 0; i < min.length(); i++) {
            for (int j = 0; j < i+1; j++) {
                if (max.contains(min.substring(j, min.length()-i+j))) {
                    max= min.substring(j,min.length() - i + j);
                }

            }

        }
        System.out.println(max);
    }

    public static void sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
//        Arrays.toString(arr);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            buffer.append(arr[i]);

        }
        System.out.println(buffer.toString());
    }
}
